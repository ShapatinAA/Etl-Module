package org.ashapatin.etl.app;

import org.ashapatin.etl.app.exception.EtlException;
import org.ashapatin.etl.app.exception.IncorrectInputException;
import org.ashapatin.etl.extract.Extract;
import org.ashapatin.etl.extract.ExtractFactory;
import org.ashapatin.etl.extract.exception.IncorrectSourceNameException;
import org.ashapatin.etl.load.Load;
import org.ashapatin.etl.load.LoadFactory;
import org.ashapatin.etl.load.exception.IncorrectReceiverNameException;
import org.ashapatin.etl.transform.Transform;
import org.ashapatin.etl.transform.TransformFactory;

/**
 * <h2>EtlApplication</h2>
 * <p>This is main class which runs whole etl-module logic.</p>
 */
public class EtlApplication {

  /** Stores name of the source from which extractor will take data. */
  public String sourceName;
  /** Stores name of the receiver which will take data from transformer. */
  public String receiverName;
  /** Stores the source information from which extractor will take data. */
  public String sourceInfo;

  private EtlApplication() {
    sourceName = "";
    receiverName = "";
    sourceInfo = "";
  }

  /**
   * <p>Constructor of <code>EtlApplication</code> class. It takes arguments as atl-module command
   * line parameters.</p>
   * @param parameters Consist of command line parameters, that were given when launching
   * .etl-module
   */
  public EtlApplication(String[] parameters) {
    this();
    if (parameters.length > 0) {
      String[] args = parameters[0].toLowerCase().split("to", 2);
      sourceName = args[0];
      receiverName = args[1];
    }
    if (parameters.length > 1) {
      sourceInfo = parameters[1];
    }
  }

/**
 * <p>Method, which is responsible for starting the whole etl-module logic. It uses parameters from
 * command line, which were given to constructor of this object.</p>
 * @throws EtlException This method can throw any kind of exception inherited from
 * <code>EtlException</code>.
 */
  public void run() throws Exception {
    validateInput();
    Extract extractor = getExtractor();
    Transform transformer = getTransformer();
    Load loader = getLoader();
    loader.load(transformer.transform(extractor.extract(sourceInfo)));

  }

  /**
   * <p>Method, which is responsible for determining and returning handler for extract process.
   * It does according to input arguments.
   * </p>
   * @return Handler of specific extractor to use.
   */
  private Extract getExtractor() throws IncorrectSourceNameException {
    return ExtractFactory.createExtractor(sourceName);
  }

  private Transform getTransformer() {
    return TransformFactory.createTransformer();
  }

  private Load getLoader() throws IncorrectReceiverNameException {
    return LoadFactory.createLoader(receiverName);
  }

  /**
   * <p>Method, that validates arguments given to this etl-module on start. Process of validation
   * consist of checking input lines on blankness. </p>
   * @throws IncorrectInputException If no arguments were given to etl-module it throws this
   * exception.
   */
  private void validateInput() throws IncorrectInputException {
    if (sourceName.isBlank() || receiverName.isBlank()) {
      throw new IncorrectInputException("Some of crucial command parameters are missing. Please, "
          + "refer to the documentation for using correct command parameters.");
    }
  }


}
