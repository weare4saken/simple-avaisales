-- liquibase formatted sql

-- changeset weare4saken:4
INSERT INTO airport (name, city, address) VALUES
    ('Шереметьево', 'Москва', 'адрес №1'),
    ('Толмачево', 'Новосибирск', 'адрес №2'),
    ('Пулково', 'Санкт-Петербург', 'адрес №3'),
    ('им.Леонова', 'Кемерово', 'адрес №4'),
    ('Домодедово', 'Москва', 'адрес №5');

-- changeset weare4saken:5
INSERT INTO airline (name) VALUES
    ('S7'),
    ('Aeroflot'),
    ('Pobeda'),
    ('TurkishAirlines'),
    ('FlyEmirates');

-- changeset weare4saken:6
INSERT INTO flight (
                    flight_number,
                    departure_airport_id,
                    arrival_airport_id,
                    airline_id,
                    departure_date,
                    arrival_date) VALUES
    ('DL1754', 1, 2, 1, '2023-11-01 08:30:00', '2023-11-01 11:45:00'),
    ('UA153', 2, 3, 2, '2023-11-02 13:15:00', '2023-11-02 15:55:00'),
    ('AA1243', 3, 4, 3, '2023-11-03 09:00:00', '2023-11-03 12:10:00'),
    ('WN1567', 4, 5, 4, '2023-11-04 11:20:00', '2023-11-04 14:40:00'),
    ('AS230', 5, 1, 5, '2023-11-05 18:45:00', '2023-11-05 21:30:00');

