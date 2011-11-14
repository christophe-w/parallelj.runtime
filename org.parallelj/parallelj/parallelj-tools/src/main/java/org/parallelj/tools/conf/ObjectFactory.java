//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.14 at 04:56:09 PM CET 
//


package org.parallelj.tools.conf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the parallelj package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Configuration_QNAME = new QName("parallelj", "configuration");
    private final static QName _Procedures_QNAME = new QName("parallelj", "procedures");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: parallelj
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CProcedures.Procedure }
     * 
     */
    public CProcedures.Procedure createCProceduresProcedure() {
        return new CProcedures.Procedure();
    }

    /**
     * Create an instance of {@link ParalleljConfiguration }
     * 
     */
    public ParalleljConfiguration createParalleljConfiguration() {
        return new ParalleljConfiguration();
    }

    /**
     * Create an instance of {@link CProcedures }
     * 
     */
    public CProcedures createCProcedures() {
        return new CProcedures();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParalleljConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "parallelj", name = "configuration")
    public JAXBElement<ParalleljConfiguration> createConfiguration(ParalleljConfiguration value) {
        return new JAXBElement<ParalleljConfiguration>(_Configuration_QNAME, ParalleljConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CProcedures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "parallelj", name = "procedures")
    public JAXBElement<CProcedures> createProcedures(CProcedures value) {
        return new JAXBElement<CProcedures>(_Procedures_QNAME, CProcedures.class, null, value);
    }

}
