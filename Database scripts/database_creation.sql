
CREATE SEQUENCE public.book_status_book_status_id_seq;

CREATE TABLE public.book_status (
                book_status_id INTEGER NOT NULL DEFAULT nextval('public.book_status_book_status_id_seq'),
                book_status_name VARCHAR(50) NOT NULL,
                CONSTRAINT book_status_pk PRIMARY KEY (book_status_id)
);


ALTER SEQUENCE public.book_status_book_status_id_seq OWNED BY public.book_status.book_status_id;

CREATE SEQUENCE public.role_role_id_seq;

CREATE TABLE public.role (
                role_id INTEGER NOT NULL DEFAULT nextval('public.role_role_id_seq'),
                role_name VARCHAR(15) NOT NULL,
                CONSTRAINT role_pk PRIMARY KEY (role_id)
);


ALTER SEQUENCE public.role_role_id_seq OWNED BY public.role.role_id;

CREATE SEQUENCE public.users_user_id_seq;

CREATE TABLE public.users (
                user_id INTEGER NOT NULL DEFAULT nextval('public.users_user_id_seq'),
                login VARCHAR(30) NOT NULL,
                password VARCHAR(100) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                first_name VARCHAR(50) NOT NULL,
                email VARCHAR(100) NOT NULL,
                role_id INTEGER NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (user_id)
);


ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;

CREATE SEQUENCE public.department_department_id_seq;

CREATE TABLE public.department (
                department_id INTEGER NOT NULL DEFAULT nextval('public.department_department_id_seq'),
                code VARCHAR(3) NOT NULL,
                department_name VARCHAR(50) NOT NULL,
                CONSTRAINT department_pk PRIMARY KEY (department_id)
);


ALTER SEQUENCE public.department_department_id_seq OWNED BY public.department.department_id;

CREATE SEQUENCE public.city_city_id_seq;

CREATE TABLE public.city (
                city_id INTEGER NOT NULL DEFAULT nextval('public.city_city_id_seq'),
                zip_code VARCHAR(5) NOT NULL,
                city_name VARCHAR(100) NOT NULL,
                department_id INTEGER NOT NULL,
                CONSTRAINT city_pk PRIMARY KEY (city_id)
);


ALTER SEQUENCE public.city_city_id_seq OWNED BY public.city.city_id;

CREATE SEQUENCE public.eple_eple_id_seq;

CREATE TABLE public.eple (
                eple_id INTEGER NOT NULL DEFAULT nextval('public.eple_eple_id_seq'),
                rne VARCHAR(8) NOT NULL,
                department_id INTEGER NOT NULL,
                city_id INTEGER NOT NULL,
                eple_name VARCHAR(100) NOT NULL,
                CONSTRAINT eple_pk PRIMARY KEY (eple_id)
);


ALTER SEQUENCE public.eple_eple_id_seq OWNED BY public.eple.eple_id;

CREATE SEQUENCE public.prescription_prescription_id_seq;

CREATE TABLE public.prescription (
                prescription_id INTEGER NOT NULL DEFAULT nextval('public.prescription_prescription_id_seq'),
                prescription_name VARCHAR(150) NOT NULL,
                creation_date TIMESTAMP NOT NULL,
                user_id INTEGER NOT NULL,
                purchase_deadline TIMESTAMP NOT NULL,
                validation_status BOOLEAN DEFAULT false NOT NULL,
                eple_id INTEGER NOT NULL,
                CONSTRAINT prescription_pk PRIMARY KEY (prescription_id)
);


ALTER SEQUENCE public.prescription_prescription_id_seq OWNED BY public.prescription.prescription_id;

CREATE TABLE public.processing_prescription (
                user_id INTEGER NOT NULL,
                prescription_id INTEGER NOT NULL,
                processing_status BOOLEAN DEFAULT false NOT NULL,
                CONSTRAINT processing_prescription_pk PRIMARY KEY (user_id, prescription_id)
);


CREATE SEQUENCE public.book_book_id_seq;

CREATE TABLE public.book (
                book_id INTEGER NOT NULL DEFAULT nextval('public.book_book_id_seq'),
                ean VARCHAR(13) NOT NULL,
                title VARCHAR(150) NOT NULL,
                author VARCHAR(150) NOT NULL,
                comments VARCHAR(2000),
                email_teacher_send BOOLEAN,
                email_send_date TIMESTAMP,
                book_status_id INTEGER NOT NULL,
                prescription_id INTEGER NOT NULL,
                CONSTRAINT book_pk PRIMARY KEY (book_id)
);


ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.book_id;

CREATE TABLE public.processing_book (
                user_id INTEGER NOT NULL,
                book_id INTEGER NOT NULL,
                processing_status BOOLEAN DEFAULT false NOT NULL,
                CONSTRAINT processing_book_pk PRIMARY KEY (user_id, book_id)
);


CREATE TABLE public.users_eple (
                user_id INTEGER NOT NULL,
                eple_id INTEGER NOT NULL,
                CONSTRAINT users_eple_pk PRIMARY KEY (user_id, eple_id)
);


ALTER TABLE public.book ADD CONSTRAINT book_status_book_fk
FOREIGN KEY (book_status_id)
REFERENCES public.book_status (book_status_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users ADD CONSTRAINT role_users_fk
FOREIGN KEY (role_id)
REFERENCES public.role (role_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users_eple ADD CONSTRAINT users_users_eple_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.prescription ADD CONSTRAINT users_prescriptions_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.processing_book ADD CONSTRAINT users_processing_book_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.processing_prescription ADD CONSTRAINT users_processing_prescription_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.eple ADD CONSTRAINT department_eple_fk
FOREIGN KEY (department_id)
REFERENCES public.department (department_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.city ADD CONSTRAINT department_city_fk
FOREIGN KEY (department_id)
REFERENCES public.department (department_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.eple ADD CONSTRAINT city_eple_fk
FOREIGN KEY (city_id)
REFERENCES public.city (city_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users_eple ADD CONSTRAINT eple_users_eple_fk
FOREIGN KEY (eple_id)
REFERENCES public.eple (eple_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.prescription ADD CONSTRAINT eple_prescription_fk
FOREIGN KEY (eple_id)
REFERENCES public.eple (eple_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.book ADD CONSTRAINT prescriptions_book_fk
FOREIGN KEY (prescription_id)
REFERENCES public.prescription (prescription_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.processing_prescription ADD CONSTRAINT prescription_processing_prescription_fk
FOREIGN KEY (prescription_id)
REFERENCES public.prescription (prescription_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.processing_book ADD CONSTRAINT book_processing_book_fk
FOREIGN KEY (book_id)
REFERENCES public.book (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
