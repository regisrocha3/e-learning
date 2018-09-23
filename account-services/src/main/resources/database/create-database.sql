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
	
	constraint pk_contact 		primary key (id)
);

-- definicao da tabela de perfil
CREATE TABLE profile(
	email 				varchar(150) not null,
	name 				varchar(255) not null,
	birthdate			date			 null,
	photo				bytea 			 null,
	gender				varchar(1)		 null,
	created				timestamp	 not null,	
	modified			timestamp	 not null,
	
	constraint pk_profile primary key (email)
);
    
-- Definicao da tabela de conta    
CREATE TABLE account(
	email 				varchar(150) not null,
	password			varchar(150) not null,
	id_contact			varchar(50) 	 null,
	created				timestamp 	 not null,
	modified			timestamp 	 not null,
	id_profile			varchar(50)  not null,
	
	constraint pk_account 		primary key (email),
	constraint fk_acc_contact 	foreign key(id_contact) references contact(id)
);


-- token de sessao do usuario
CREATE TABLE token_session_account(
	tokenId 		varchar(50) 	not null,
	email 			varchar(150) 	not null,
	created			timestamp 	 	not null,
	modified		timestamp 	 	not null,
	is_expired		varchar(1)		not null,
	
	constraint pk_token_session_acc 		primary key (email),
	constraint fk_token_account 			foreign key(email) references account(email)
);
















