curl -i -X POST -H "Content-Type: application/json" -d "{\"imie\":\"Arkadiusz\",\"nazwisko\":\"Polak\",\"pesel\":\"96063001234\",\"telefon\":\"567890123\",\"pkk\":\"01234567890123456789\"}" http://127.0.0.1:8080/osk/participants/register
curl -i -X POST -H "Content-Type: application/json" -d "{\"imie\":\"Janusz\",\"nazwisko\":\"Biznes\",\"pesel\":\"55022209089\",\"telefon\":\"678901234\",\"pkk\":\"23456789012345678901\"}" http://127.0.0.1:8080/osk/participants/register

curl -i -X POST -H "Content-Type: application/json" -d "{\"imie\":\"Hubert\",\"nazwisko\":\"Parafiniuk\"}" http://127.0.0.1:8080/osk/instructors/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"imie\":\"Marek\",\"nazwisko\":\"Ryba\"}" http://127.0.0.1:8080/osk/instructors/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"imie\":\"Karol\",\"nazwisko\":\"Wygnany\"}" http://127.0.0.1:8080/osk/instructors/add

curl -i -X POST -H "Content-Type: application/json" -d "{\"oznaczenie\":\"B\",\"kategoria\":\"samochod osobowy do 3,5 t\"}" http://127.0.0.1:8080/osk/courses/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"oznaczenie\":\"A\",\"kategoria\":\"motocykl\"}" http://127.0.0.1:8080/osk/courses/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"oznaczenie\":\"AM\",\"kategoria\":\"motorower\"}" http://127.0.0.1:8080/osk/courses/add

curl -i -X POST -H "Content-Type: application/json" -d "{\"typ\":\"samochod osobowy\",\"nazwa\":\"Suzuki Swift\",\"nrRejestracyjny\":\"LRA 12580\"}" http://127.0.0.1:8080/osk/vehicles/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"typ\":\"motocykl\",\"nazwa\":\"Yamaha TZR 50/70\",\"nrRejestracyjny\":\"LRA 0022\"}" http://127.0.0.1:8080/osk/vehicles/add
curl -i -X POST -H "Content-Type: application/json" -d "{\"typ\":\"motorower\",\"nazwa\":\"Bardzo nieznany model\",\"nrRejestracyjny\":\"LRA 0000\"}" http://127.0.0.1:8080/osk/vehicles/add

curl -i -X POST -H "Content-Type: application/json" -d "{\"temat\":\"Znaki ostrzegawcze\",\"date\":\"2020-06-14\",\"timea\":\"15:00\",\"sumHour\":2}" http://127.0.0.1:8080/osk/lectures/instructor/determine/3/1
curl -i -X POST -H "Content-Type: application/json" -d "{\"temat\":\"Znaki nakazu\",\"date\":\"2020-06-15\",\"timea\":\"15:00\",\"sumHour\":2}" http://127.0.0.1:8080/osk/lectures/instructor/determine/3/1

curl -i -X POST -H "Content-Type: application/json" -d "{\"date\":\"2020-06-14\",\"time\":\"15:00\",\"sumHour\":2}" http://127.0.0.1:8080/osk/driving_lessons//instructor/determine/4/2/6/9
curl -i -X POST -H "Content-Type: application/json" -d "{\"date\":\"2020-06-15\",\"time\":\"15:00\",\"sumHour\":2}" http://127.0.0.1:8080/osk/driving_lessons//instructor/determine/4/2/6/9

Pause