package org.ashapatin.etl.transform;

import org.ashapatin.etl.transform.exception.TransformException;

public interface Transform<IN, OUT> {

  public OUT transform(IN data) throws TransformException;

}
