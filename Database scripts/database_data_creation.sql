/* INSERT INTO department */
INSERT INTO public.department (code, department_name) 
	VALUES
		('029', 'Finistère');

/* INSERT INTO city */
INSERT INTO public.city (zip_code, city_name, department_id) 
	VALUES
		('29200', 'Brest', 1);

/* INSERT INTO eple */
INSERT INTO public.eple (rne, department_id, city_id, eple_name) 
	VALUES
		('0292047T', 1, 1, 'Lycée Champollion');


/* INSERT INTO role */
INSERT INTO public.role (role_name) 
	VALUES
		('libraire'),
		('enseignant');

/* INSERT INTO users */
INSERT INTO public.users (login, password, last_name, first_name, email, role_id) 
	VALUES
		('fred', 'pass', 'Fouret', 'Frédéric', 'fouretfrederic@gmail.com', 1),
		('pierre', 'pass', 'Carré', 'Pierre', 'carrepierre@test.com', 2);

/* INSERT INTO users_eple */
INSERT INTO public.users_eple (user_id, eple_id)
	VALUES
		(2, 1);


/* INSERT INTO prescription */
INSERT INTO public.prescription (prescription_name, creation_date, user_id, purchase_deadline, validation_status, eple_id) 
	VALUES
		('Cours japonais débutant', '2019-01-15 09:15:00', 2, '2019-09-01 00:00:00', false, 1);

/* INSERT INTO processing_prescription */
INSERT INTO public.processing_prescription (user_id, prescription_id, processing_status) 
	VALUES
		(1, 1, false);


/* INSERT INTO book_status */
INSERT INTO public.book_status (book_status_name)
	VALUES
		('disponible'),
		('indisponible'),
		('épuisé');


/* INSERT INTO book */
INSERT INTO public.book (ean, title, author, comments, email_teacher_send, email_send_date, book_status_id, prescription_id) 
	VALUES
		('9782720012006', 'Kanji & Kana', 'Pierre Durmous', null, false, null, 1, 1);

/* INSERT INTO processing_book */
INSERT INTO public.processing_book (user_id, book_id, processing_status) 
	VALUES
		(1, 1, false);
