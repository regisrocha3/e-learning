CREATE DATABASE "elearning-acount"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "elearning-acount"
    IS 'Database to manage information about Account';
    

    
-- definicao da tabela de contato
CREATE TABLE contact(
	id				varchar(50) 	not null,
	ddi_code		varchar(3) 	 		null,
	ddd_code		varchar(3) 	 		null,
	phone_number	varchar(20) 	 	null,
	description		varchar(500) 	 	null,
	secondary_email varchar(150) 	 	null,
	
	constraint pk_contact 		primary key (id),
);
    
    
-- Definicao da tabela de conta    
CREATE TABLE account(
	email 				varchar(150) not null,
	password			varchar(150) not null,
	id_contact			varchar(50) 	 null,
	
	
	constraint pk_account 		primary key (email),
	constraint fk_acc_contact 	foreign key(id_contact) references (id)
);



















