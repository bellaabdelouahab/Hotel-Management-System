OJDBC-FULL.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc-full.tar.gz) contains the 12.1.0.1 release of the Oracle JDBC Thin driver (ojdbc7.jar for JDK7 and JDK8 and ojdbc6.jar for JDK6), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc7.jar (3,397,734 bytes) - (SHA1 Checksum: a2348e4944956fac05235f7cd5d30bf872afb157)
Certified with JDK7 and JDK 8; It contains the JDBC driver classes except classes for NLS support in Oracle Object and Collection types.

(2) ojdbc6.jar (3,389,454 bytes) - (SHA1 Checksum: 5d5d3e7a6b217ddc0c1c4c6d14b352e8b04453ef)
For use with JDK 6; It contains the JDBC driver classes except classes for NLS support in Oracle Object and Collection types. 

(3) ucp.jar (583,371 bytes) - (SHA1 Checksum: 7f21ba5dc542f8b672b312d50106fe045b89f363)
(Refer MOS note DOC ID 2074693.1) - UCP classes for use with JDK 6 & JDK 7

(4) ojdbc.policy (10,542 bytes) - Sample security policy file for Oracle Database JDBC drivers

=============================
JARs for NLS and XDK support 
=============================
(5) orai18n.jar (1,659,576 bytes) - (SHA1 Checksum: 216a545f85a5b356d182c5963b2e92d862216bdc) 
Classes for NLS support

(6) xdb6.jar (263,690 bytes) - (SHA1 Checksum: dda7907a5a608391c8a8abef68255cfc6f9d2f46)
Classes to support standard JDBC 4.x java.sql.SQLXML interface (Java SE 6 & Java SE 7).

====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================

(7) simplefan.jar (21,048 bytes) - (SHA1 Checksum: 13a3c504fb7ee9517327b1efe13dd5fa3fa125c3)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

(8) ons.jar (105,016 bytes) - (SHA1 Checksum: aee1afae39a7b7609a3290f7b92697db3ec53398)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon

=================
OTHER RESOURCES
=================
Refer to the 12.1 JDBC Developers Guide (https://docs.oracle.com/database/121/JJDBC/toc.htm) and Universal Connection Pool Developers Guide (https://docs.oracle.com/database/121/JJUCP/toc.htm) for more details. 
