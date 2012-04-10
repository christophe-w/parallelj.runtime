/*
 *     ParallelJ, framework for parallel computing
 *
 *     Copyright (C) 2010, 2011, 2012 Atos Worldline or third-party contributors as
 *     indicated by the @author tags or express copyright attribution
 *     statements applied by the authors.
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.05 at 05:27:27 PM CEST 
//


package org.parallelj.internal.conf.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CServers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CServers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://parallelj.org}telnet"/>
 *         &lt;element ref="{http://parallelj.org}jmx"/>
 *         &lt;element ref="{http://parallelj.org}ssh"/>
 *         &lt;element ref="{http://parallelj.org}beans"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CServers", propOrder = {
    "telnet",
    "jmx",
    "ssh",
    "beans"
})
public class CServers {

    @XmlElement(required = true)
    protected CTelnet telnet;
    @XmlElement(required = true)
    protected CJmx jmx;
    @XmlElement(required = true)
    protected CSsh ssh;
    @XmlElement(required = true)
    protected CBeans beans;

    /**
     * Gets the value of the telnet property.
     * 
     * @return
     *     possible object is
     *     {@link CTelnet }
     *     
     */
    public CTelnet getTelnet() {
        return telnet;
    }

    /**
     * Sets the value of the telnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTelnet }
     *     
     */
    public void setTelnet(CTelnet value) {
        this.telnet = value;
    }

    /**
     * Gets the value of the jmx property.
     * 
     * @return
     *     possible object is
     *     {@link CJmx }
     *     
     */
    public CJmx getJmx() {
        return jmx;
    }

    /**
     * Sets the value of the jmx property.
     * 
     * @param value
     *     allowed object is
     *     {@link CJmx }
     *     
     */
    public void setJmx(CJmx value) {
        this.jmx = value;
    }

    /**
     * Gets the value of the ssh property.
     * 
     * @return
     *     possible object is
     *     {@link CSsh }
     *     
     */
    public CSsh getSsh() {
        return ssh;
    }

    /**
     * Sets the value of the ssh property.
     * 
     * @param value
     *     allowed object is
     *     {@link CSsh }
     *     
     */
    public void setSsh(CSsh value) {
        this.ssh = value;
    }

    /**
     * Gets the value of the beans property.
     * 
     * @return
     *     possible object is
     *     {@link CBeans }
     *     
     */
    public CBeans getBeans() {
        return beans;
    }

    /**
     * Sets the value of the beans property.
     * 
     * @param value
     *     allowed object is
     *     {@link CBeans }
     *     
     */
    public void setBeans(CBeans value) {
        this.beans = value;
    }

}