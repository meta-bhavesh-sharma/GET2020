package SOAPTriangle;

public class ShapeProxy implements SOAPTriangle.Shape {
  private String _endpoint = null;
  private SOAPTriangle.Shape shape = null;
  
  public ShapeProxy() {
    _initShapeProxy();
  }
  
  public ShapeProxy(String endpoint) {
    _endpoint = endpoint;
    _initShapeProxy();
  }
  
  private void _initShapeProxy() {
    try {
      shape = (new SOAPTriangle.ShapeServiceLocator()).getShape();
      if (shape != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shape)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shape)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shape != null)
      ((javax.xml.rpc.Stub)shape)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SOAPTriangle.Shape getShape() {
    if (shape == null)
      _initShapeProxy();
    return shape;
  }
  
  public double getTriangleArea(double a, double b, double c) throws java.rmi.RemoteException{
    if (shape == null)
      _initShapeProxy();
    return shape.getTriangleArea(a, b, c);
  }
  
  
}