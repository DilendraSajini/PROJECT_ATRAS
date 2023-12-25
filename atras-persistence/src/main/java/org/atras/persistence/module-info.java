  module org.atras.persistence {
	  exports org.atras.persistence.exception;
	  exports org.atras.persistence.repository;
	  exports org.atras.persistence.model;
	  exports org.atras.persistence.mapper;
	  requires org.atras.core;
	  requires java.persistence;
	  requires spring.beans;
	  requires spring.context;
	  requires java.validation;
	  requires spring.data.jpa;
  }