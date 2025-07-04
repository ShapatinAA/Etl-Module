package org.ashapatin.etl.load;

/**
 * <h2>Load</h2>
 * <p><code>Load</code> is an interface of all load classes. It is supposed to
 * to be able to perform load operation to specified receiver. It must implement
 * {@link #load(T)} method. And it is recommended to all implementations of this class
 * to check if the receiver info given is correct, tho not necessary. It can have additional
 * methods and fields if needed.</p>
 * @param <T> is a parameter, that specifies type of object, that will be used by
 * {@link #load(T)}.
 */
public interface Load<T> {

  /**
   * <p>This is a main method that should be implemented by any implementation of {@link Load}
   * interface. This method should extract information from specified source and return
   * POJO of this information.</p>
   * @param data
   */
  public void load(T data) throws Exception;
}
