/* INSERT INTO department */
INSERT INTO public.department (code, department_name) 
	VALUES
		('029', 'Finistère'),
		('030', 'Gard');

/* INSERT INTO city */
INSERT INTO public.city (zip_code, city_name, department_id) 
	VALUES
		('29200', 'Brest', 1),
		('30000', 'Nimes', 2);

/* INSERT INTO eple */
INSERT INTO public.eple (rne, department_id, city_id, eple_name) 
	VALUES
		('0292047T', 1, 1, 'Lycée Champollion'),
		('0302055A', 2, 2, 'Collège Jean Monnet');


/* INSERT INTO role */
INSERT INTO public.role (role_name) 
	VALUES
		('libraire'),
		('enseignant');

/* INSERT INTO users */
INSERT INTO public.users (login, password, last_name, first_name, email, role_id) 
	VALUES
		('fred', '$2a$10$qD/S8Wv/isAF12ADRdRsZ.M35zpWTdEkofs1/f8vQTFsf1htwTba.', 'F', 'Frédéric', 'ffrederic@test.com', 1),
		('pierre', '$2a$10$qD/S8Wv/isAF12ADRdRsZ.M35zpWTdEkofs1/f8vQTFsf1htwTba.', 'Carré', 'Pierre', 'carrepierre@test.com', 2),
		('modifyUser', '$2a$10$qD/S8Wv/isAF12ADRdRsZ.M35zpWTdEkofs1/f8vQTFsf1htwTba.', 'modify', 'user', 'moduser@test.com', 1),
		('fredericf', '$2a$10$qD/S8Wv/isAF12ADRdRsZ.M35zpWTdEkofs1/f8vQTFsf1htwTba.', 'F', 'Frédéric', 'ffrederic@test.com', 2);
	
/* INSERT INTO users_eple */
INSERT INTO public.users_eple (user_id, eple_id)
	VALUES
		(2, 1),
		(4, 2);

/* INSERT INTO prescription */
INSERT INTO public.prescription (prescription_name, creation_date, user_id, purchase_deadline, validation_status, eple_id, headcount) 
	VALUES
		('Cours japonais débutant', '2019-01-15 09:15:00', 2, '2019-09-01 00:00:00', false, 1, 35),
		('Robot et IA', '2019-03-01 08:00:00', 4, '2019-06-01 00:00:00', false, 2, 25);

/* INSERT INTO processing_prescription */
INSERT INTO public.processing_prescription (user_id, prescription_id, processing_status) 
	VALUES
		(1, 1, true);


/* INSERT INTO book_status */
INSERT INTO public.book_status (book_status_name)
	VALUES
		('disponibilité non vérifiée'),
		('disponible'),
		('indisponible'),
		('épuisé');


/* INSERT INTO book */
INSERT INTO public.book (ean, title, author, comments, email_teacher_send, email_send_date, book_status_id, prescription_id) 
	VALUES
		('9782720012006', 'Kanji & Kana', 'Pierre Durmous', null, false, null, 1, 1),
		('9784883191338', 'Minna no Nihongo I', 'Iwao Ogawa', null, false, null, 1, 1),
		('9782290055953', ' Les robots', 'Isaac Asimov', null, false, null, 1, 2),
		('9782290111437', 'La justice de l''ancillaire', 'Ann Leckie', null, false, null, 1, 2);

/* INSERT INTO processing_book */
INSERT INTO public.processing_book (user_id, book_id, processing_status) 
	VALUES
		(1, 1, false),
		(1, 2, true),
		(1, 3, false),
		(1, 4, true);
