package org.ashapatin.etl.transform;

/**
 * <h2>TransformFactory</h2>
 * <p>This is a factory-class of objects, which implements {@link Transform}
 * interface.</p>
 */
public final class TransformFactory {
  public static Transform createTransformer() {
    return new TransformWeather();
  }
}