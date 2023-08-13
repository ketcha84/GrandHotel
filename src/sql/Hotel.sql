
DROP TABLE IF EXISTS rooms CASCADE;
DROP TABLE IF EXISTS discounts CASCADE;
DROP TABLE IF EXISTS vat CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS orders CASCADE;


DROP SEQUENCE IF EXISTS rooms_sequence CASCADE;
DROP SEQUENCE IF EXISTS users_sequence CASCADE;
DROP SEQUENCE IF EXISTS orders_sequence CASCADE;
DROP SEQUENCE IF EXISTS accounts_sequence CASCADE;
DROP SEQUENCE IF EXISTS discounts_sequence CASCADE;
DROP SEQUENCE IF EXISTS vat_sequence CASCADE;

DROP TYPE IF EXISTS roles CASCADE;
DROP TYPE IF EXISTS discounts_types CASCADE;
DROP TYPE IF EXISTS status CASCADE;

CREATE SEQUENCE rooms_sequence START WITH 100;
CREATE SEQUENCE users_sequence START WITH 100;
CREATE SEQUENCE orders_sequence START WITH 100;
CREATE SEQUENCE accounts_sequence START WITH 100;
CREATE SEQUENCE discounts_sequence START WITH 1;
CREATE SEQUENCE vat_sequence START WITH 1;

CREATE TYPE status AS ENUM (
	'NEW',
	'CONFIRMED',
	'PAYED',
	'CLOSED',
	'BANNED'
);

CREATE TYPE roles AS ENUM(
	'ADMIN',
	'MANAGER',
	'USER'
);

CREATE TYPE discounts_types AS ENUM(
	'PENSIONER',
	'INVALID',
	'NORMAL'
);

CREATE TABLE discounts(
	id_discount INTEGER DEFAULT nextval('discounts_sequence'),
	description VARCHAR(100) NOT NULL,
	discount_type discounts_types,
	percents NUMERIC(3,2) DEFAULT('0.00') NOT NULL,
	
	CONSTRAINT percents_ch CHECK(percents >= 0.00 AND percents < 1),
	CONSTRAINT id_discount_pk PRIMARY KEY(id_discount)
);

CREATE TABLE vat(
	id_vat INTEGER DEFAULT nextval('vat_sequence') NOT NULL,
	vat NUMERIC(3,2) DEFAULT('0.00') NOT NULL,
	
	CONSTRAINT vat_ch CHECK(vat >= 0.00 AND vat < 1),
	CONSTRAINT id_vat_pk PRIMARY KEY (id_vat)
);

CREATE TABLE accounts(
	account_id INTEGER DEFAULT nextval('accounts_sequence') NOT NULL,
	account_login VARCHAR(50) NOT NULL,
	account_password VARCHAR(50) NOT NULL,
	account_role roles,
	
	CONSTRAINT account_id_pk PRIMARY KEY(account_id)
);

CREATE TABLE rooms (
	room_id INTEGER DEFAULT nextval('rooms_sequence') NOT NULL,
	amount_of_rooms INTEGER NOT NULL,
	price NUMERIC(6,2) NOT NULL,
	luxury BOOLEAN DEFAULT FALSE,
	reference_www VARCHAR(100) NOT NULL,
	
	CONSTRAINT room_id_pk PRIMARY KEY (room_id),
	CONSTRAINT price_ch CHECK(price > 0)
);

CREATE TABLE users (
	user_id INTEGER DEFAULT nextval ('users_sequence') NOT NULL,
	user_name VARCHAR (50) NOT NULL,
	user_lastName VARCHAR(50) NOT NULL,
	user_email VARCHAR(100) NOT NULL,
	user_phone VARCHAR(15),
	user_password VARCHAR(50) NOT NULL,
	user_status status NOT NULL,
	
	CONSTRAINT user_id_pk PRIMARY KEY (user_id),
	CONSTRAINT user_email_uk UNIQUE(user_email),
	CONSTRAINT user_phone_uk UNIQUE (user_phone)
);

CREATE TABLE orders(
	order_id INTEGER DEFAULT nextval('orders_sequence') NOT NULL,
	user_id INTEGER NOT NULL,
	room_id INTEGER NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	amount_normal INTEGER,
	amount_pensioner INTEGER,
	amount_invalid INTEGER,
	description TEXT,
	order_status status NOT NULL,
	
	CONSTRAINT order_id_pk PRIMARY KEY (order_id),
	CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT room_id_fk FOREIGN KEY(room_id) REFERENCES rooms(room_id)
);