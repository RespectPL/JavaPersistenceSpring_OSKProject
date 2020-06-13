INSERT INTO participant (id, imie, nazwisko, pesel, telefon, pkk) VALUES
(1, 'Arkadiusz', 'Polak', '96063001234', '567890123', '01234567890123456789'),
(2, 'Janusz', 'Biznes', '55022209089', '678901234', '23456789012345678901');

INSERT INTO instructor (id, imie, nazwisko) VALUES
(1, 'Hubert', 'Parafiniuk'),
(2, 'Marek', 'Ryba');

INSERT INTO course (id, oznaczenie, kategoria) VALUES
(1, 'B', 'samochód osobowy <=3,5 t'),
(2, 'A', 'motocykl'),
(3, 'AM', 'motorower');

INSERT INTO vehicle (id, typ, nazwa, nr_rejestracyjny) VALUES
(1, 'samochód osobowy', 'Suzuki Swift', 'LRA 12580'),
(2, 'motocykl', 'Yamaha TZR 50/70 ', 'LRA 0022');