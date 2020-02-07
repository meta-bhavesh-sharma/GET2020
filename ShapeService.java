/**
 * ShapeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package SOAPTriangle;

public interface ShapeService extends javax.xml.rpc.Service {
    public java.lang.String getShapeAddress();

    public SOAPTriangle.Shape getShape() throws javax.xml.rpc.ServiceException;

    public SOAPTriangle.Shape getShape(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
