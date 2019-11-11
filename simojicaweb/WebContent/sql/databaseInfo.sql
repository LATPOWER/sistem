--create database simojica ENCODING 'UTF-8' LC_COLLATE 'en_US.UTF-8' LC_CTYPE 'en_US.UTF-8' TEMPLATE template0 OWNER postgres;
--grant CONNECT ON DATABASE simojica TO postgres

drop sequence expedientes_sequence;
drop sequence expedientes_consulta;
drop sequence expedientes_hist_clinica;
drop sequence expedientes_familiar;
drop sequence expedientes_direccion;
drop sequence expedientes_sequence;


create sequence expedientes_receta;
create sequence expedientes_consulta;
create sequence expedientes_hist_clinica;
create sequence expedientes_familiar;
create sequence expedientes_direccion;
create sequence expedientes_sequence;


DROP TABLE "RECETA" ;
DROP TABLE "CONSULTA" ;
DROP TABLE "HISTCLINICA" ;
DROP TABLE "FAMILIAR" ;
DROP TABLE "DIRECCION" ;
DROP TABLE "EXPEDIENTES" ;



CREATE TABLE  "RECETA" 
   (	"ID_RECETA" BIGINT NOT NULL UNIQUE, 
        "ID_CONSULTA" BIGINT NOT NULL, 
	"A_PATERNO" VARCHAR(40), 
	"A_MATERNO" VARCHAR(40), 
	"NOMBRE" VARCHAR(40), 
	"PESO_ACTUAL" VARCHAR(30), 
	"TALLA_ACTUAL" VARCHAR(30), 
	"TEMPERATURA" VARCHAR(30), 
	"EDAD" VARCHAR(30), 
	"DIRECCION" VARCHAR(1000), 
	"FECHA" DATE, 
	"RP" VARCHAR(1500),
         CONSTRAINT "PK_RECETA" PRIMARY KEY ("ID_RECETA","ID_CONSULTA")
   );

CREATE TABLE  "CONSULTA" 
   (	
        "ID_CONSULTA" BIGINT NOT NULL, 
        "IDEXPEDIENTE" BIGINT NOT NULL, 
        "ID_RECETA" BIGINT , 
        "PAD_ACTUAL" VARCHAR(1000), 
	"IMPRESION_DIAGNOSTICA" VARCHAR(1000), 
	"PLAN" VARCHAR(1000), 
	"NOMBRE" VARCHAR(1000), 
	"FECHA_ACTUAL" DATE, 
	"PESO_ACTUAL" VARCHAR(110), 
	"TALLA_ACTUAL" VARCHAR(100), 
	"TEMPERATURA" VARCHAR(110), 
	"OBSERVACIONES" VARCHAR(1500), 
	"EDAD" VARCHAR(100), 
         CONSTRAINT "PK_CONSULTA" PRIMARY KEY ("ID_CONSULTA","IDEXPEDIENTE") ,
         CONSTRAINT "FK_CONSULTA_RECETA" FOREIGN KEY ("ID_RECETA")
	  REFERENCES  "RECETA" ("ID_RECETA") ON DELETE CASCADE 
   );




CREATE TABLE  "HISTCLINICA" 
   (	"ID_HISTO_CLINICA" BIGINT NOT NULL UNIQUE, 
        "IDEXPEDIENTE" BIGINT NOT NULL , 
        "ANT_HEREDO_FAMILIARES" VARCHAR(1200), 
	"PERSONALES_PATOLOGICOS" VARCHAR(1200), 
	"SENO_MATERNO" VARCHAR(1500), 
	"INMUNIZACIONES" VARCHAR(1500), 
	"DES_PSI" VARCHAR(1500), 
	"PESO_NACIMIENTO" VARCHAR(100), 
	"TALLA_NACIMIENTO" VARCHAR(100), 
	"OBSERVACIONES" VARCHAR(1500), 
	 CONSTRAINT "PK_HISTCLINICA" PRIMARY KEY ("ID_HISTO_CLINICA","IDEXPEDIENTE")
   );


CREATE TABLE  "FAMILIAR" 
   (	
        "ID_FAMILIAR" BIGINT NOT NULL UNIQUE, 
        "IDEXPEDIENTE" BIGINT NOT NULL, 
        "A_PATERNO" VARCHAR(40), 
	"A_MATERNO" VARCHAR(40), 
	"NOMBRE" VARCHAR(40), 
	"EDAD" VARCHAR(30), 
	"OCUPACION" VARCHAR(70), 
	"FOT_M" BYTEA, 
	 CONSTRAINT "PK_FAMILIAR" PRIMARY KEY ("ID_FAMILIAR","IDEXPEDIENTE")
   );



CREATE TABLE  "DIRECCION" 
   (	
         "ID_DIRECCION" BIGINT NOT NULL UNIQUE, 
         "IDEXPEDIENTE" BIGINT NOT NULL, 
        "CALLE_AV" VARCHAR(70), 
	"NUMERO" VARCHAR(30), 
	"COLONIA" VARCHAR(70), 
	"CD_EDO" VARCHAR(70), 
	"MANZANA" VARCHAR(30), 
	"CP" VARCHAR(15), 	
	  CONSTRAINT "PK_DIRECCION" PRIMARY KEY ("ID_DIRECCION","IDEXPEDIENTE")
   );

CREATE TABLE  "EXPEDIENTES" 
   (            "IDEXPEDIENTE" BIGINT NOT NULL, 
		"APELLIDOPATERNO" VARCHAR(4000), 
		"APELLIDOMATERNO" VARCHAR(4000), 
		"NOMBRE" VARCHAR(4000), 
		"FECHAACTUAL" DATE, 
		"FECHANACIMIENTO" DATE, 
		"TELEFONO" VARCHAR(4000), 
		"EDAD" VARCHAR(100),
                "FOT" BYTEA,
		"ID_DIRECCION" BIGINT , 
		"ID_HISTO_CLINICA" BIGINT , 
		"ID_FAMILIAR1" BIGINT , 
		"ID_FAMILIAR2" BIGINT , 		
		CONSTRAINT "PK_EXPEDIENTES" PRIMARY KEY ("IDEXPEDIENTE"),
		CONSTRAINT "PK_EXPEDIENTES_DIRECCION" FOREIGN KEY ("ID_DIRECCION")
		REFERENCES  "DIRECCION" ("ID_DIRECCION") ON DELETE CASCADE ,
		CONSTRAINT "HISTCLINI_FK" FOREIGN KEY ("ID_HISTO_CLINICA")
                REFERENCES  "HISTCLINICA" ("ID_HISTO_CLINICA") ON DELETE CASCADE ,
		CONSTRAINT "PK_EXPEDIENTES_FAMILIAR_1" FOREIGN KEY ("ID_FAMILIAR1")
		REFERENCES  "FAMILIAR" ("ID_FAMILIAR") ON DELETE CASCADE ,
		CONSTRAINT "PK_EXPEDIENTES_FAMILIAR_2" FOREIGN KEY ("ID_FAMILIAR2")
		REFERENCES  "FAMILIAR" ("ID_FAMILIAR") ON DELETE CASCADE 
    );