package org.ashapatin.etl.transform;

public interface Transform<IN, OUT> {

  public OUT transform(IN data);

}
