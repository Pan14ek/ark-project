CREATE SCHEMA factory;

CREATE TABLE roles
(
    Id_role BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Title       VARCHAR(45)  NOT NULL,
    Symbol      VARCHAR(45)  NOT NULL,
    Description VARCHAR(250) NULL
);

CREATE TABLE users
(
    Id_user BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_role BIGSERIAL NOT NULL
        CONSTRAINT users_role_fk REFERENCES roles,
    First_name VARCHAR(50)  NOT NULL,
    Last_name  VARCHAR(50)  NOT NULL,
    Login      VARCHAR(50)  NOT NULL,
    Email      VARCHAR(100) NOT NULL,
    Password   VARCHAR(80)  NOT NULL
);

CREATE TABLE points_config
(
    Id_point_config BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Default_points INT NOT NULL,
    Extra_points   INT NOT NULL
);

CREATE TABLE work_logs
(
    Id_work_log BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_user BIGSERIAL NOT NULL
        CONSTRAINT work_logs_user REFERENCES users,
    Work_date     TIMESTAMP NOT NULL,
    Amount_points INT       NOT NULL
);

CREATE TABLE units
(
    Id_unit BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Title       VARCHAR(100) NOT NULL,
    Description VARCHAR(250) NULL,
    Status      VARCHAR(50)  NOT NULL
);

CREATE TABLE work_places
(
    Id_work_place BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_unit BIGSERIAL NOT NULL
        CONSTRAINT work_places_unit REFERENCES units,
    Title VARCHAR(100) NOT NULL,
    Size  INT          NOT NULL
);

CREATE TABLE user_places
(
    Id_user_place BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_work_place BIGSERIAL NOT NULL
        CONSTRAINT Id_user_place_work_place_fk REFERENCES work_places,
    Id_user BIGSERIAL NOT NULL
        CONSTRAINT Id_user_place_user_fk REFERENCES users
);

CREATE TABLE personal_schedules
(
    Id_personal_schedule BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Amount_days INT NOT NULL
);

CREATE TABLE users_personal_schedules
(
    Id_user_personal_schedule BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_personal_schedule BIGSERIAL NOT NULL CONSTRAINT Id_personal_schedule_fk REFERENCES personal_schedules,
    Id_user BIGSERIAL NOT NULL CONSTRAINT Id_personal_schedule_user REFERENCES users,
    Work_date TIMESTAMP NOT NULL,
    Confirm   BOOLEAN   NOT NULL
);

CREATE TABLE filters
(
    Id_filter BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    title       VARCHAR(100) NOT NULL UNIQUE,
    diameter    DECIMAL      NOT NULL,
    filter_type VARCHAR(100) NOT NULL
);

CREATE TABLE Chemical_Substances
(
    Id_chemical_substance BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    title   VARCHAR(100) NOT NULL,
    formula VARCHAR(200) NOT NULL
);

CREATE TABLE Filters_Chemical_Substances
(
    Id_filter_chemical_substance BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_filter BIGSERIAL NOT NULL CONSTRAINT Id_filter_chemical_substance_fk REFERENCES filters,
    Id_chemical_substance BIGSERIAL NOT NULL CONSTRAINT Id_chemical_substance_filter_fk REFERENCES Chemical_Substances
);

CREATE TABLE Filters_units
(
    Id_filter_unit BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    Id_filter BIGSERIAL NOT NULL CONSTRAINT Id_filter_unit_fk REFERENCES filters,
    Id_unit BIGSERIAL NOT NULL CONSTRAINT Id_unit_filter_fk REFERENCES units,
    Date_install TIMESTAMP    NOT NULL,
    Status       VARCHAR(100) NOT NULL,
    Date_removal TIMESTAMP    NOT NULL
);