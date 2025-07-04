package org.ashapatin.etl.extract;

/**
 * <h2>Extract</h2>
 * <p><code>Extract</code> is an interface of all extractions classes. It is supposed to
 * to be able to perform extraction operation out of specified source. It must implement
 * {@link #extract(String)} method. And it is recommended to all implementations of this class
 * to check if the source info given is correct, tho not necessary. It can have additional
 * methods and fields if needed.</p>
 * @param <T> is a parameter, that specifies type of object, that will be constructed and returned
 * by {@link #extract(String)}.
 */
public interface Extract<T> {

/**
 * <p>This is a main method that should be implemented by any implementation of {@link Extract}
 * interface. This method should extract information from specified source and return
 * POJO of this information.</p>
 * @param sourceInfo
 */
  public T extract(String sourceInfo) throws Exception;
}
