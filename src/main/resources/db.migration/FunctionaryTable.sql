CREATE TABLE public.functionary
(
    id                                    UUID             NOT NULL,
    name                                  VARCHAR(150)     NOT NULL,
    rg                                    VARCHAR(11)      NOT NULL,
    cpf                                   VARCHAR(14)      NOT NULL,
    birth_date                            VARCHAR(10)      NOT NULL,
    age                                   INTEGER          NOT NULL,
    name_father                           VARCHAR(150),
    mother_name                           VARCHAR(150),
    personal_phone                        VARCHAR(15)      NOT NULL,
    corporate_phone                       VARCHAR(15)      NOT NULL,
    genre                                 VARCHAR(255)     NOT NULL,
    schooling                             VARCHAR(255)     NOT NULL,
    marital_status                        VARCHAR(255)     NOT NULL,
    email                                 VARCHAR(150)     NOT NULL,
    bank_account_id                       UUID,
    registration_date                     date,
    address_cep                           VARCHAR(9)       NOT NULL,
    address_street                        VARCHAR(255)     NOT NULL,
    address_number                        INTEGER          NOT NULL,
    address_complement                    VARCHAR(255),
    address_district                      VARCHAR(150)     NOT NULL,
    address_city                          VARCHAR(200)     NOT NULL,
    address_uf                            VARCHAR(2)       NOT NULL,
    address_nationality                   VARCHAR(150)     NOT NULL,
    collaborative_office                  VARCHAR(150)     NOT NULL,
    collaborative_salary                  DOUBLE PRECISION NOT NULL,
    collaborative_meal_ticket             DOUBLE PRECISION NOT NULL,
    collaborative_transportation_vouchers DOUBLE PRECISION NOT NULL,
    collaborative_work_job                VARCHAR(7)       NOT NULL,
    collaborative_admission_date          VARCHAR(10),
    collaborative_holiday_start_date      VARCHAR(10),
    collaborative_holiday_end_date        VARCHAR(10),
    collaborative_dismissal_date          VARCHAR(10),
    CONSTRAINT pk_functionary PRIMARY KEY (id)
);

ALTER TABLE public.functionary
    ADD CONSTRAINT uc_functionary_cpf UNIQUE (cpf);

ALTER TABLE public.functionary
    ADD CONSTRAINT uc_functionary_name UNIQUE (name);

ALTER TABLE public.functionary
    ADD CONSTRAINT uc_functionary_rg UNIQUE (rg);

ALTER TABLE public.functionary
    ADD CONSTRAINT FK_FUNCTIONARY_ON_BANK_ACCOUNT FOREIGN KEY (bank_account_id) REFERENCES public.bank_account (id);