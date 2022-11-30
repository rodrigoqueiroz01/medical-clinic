CREATE TABLE public.opening_hours (
    id           UUID        NOT NULL,
    open_and     VARCHAR(13) NOT NULL,
    closes_in    VARCHAR(13) NOT NULL,
    opening_time VARCHAR(5)  NOT NULL,
    closing_time VARCHAR(5)  NOT NULL,

    CONSTRAINT pk_opening_hours PRIMARY KEY (id)
);

ALTER TABLE public.opening_hours
    ADD CONSTRAINT uc_opening_hours_closes_in UNIQUE (closes_in);

ALTER TABLE public.opening_hours
    ADD CONSTRAINT uc_opening_hours_closing_time UNIQUE (closing_time);

ALTER TABLE public.opening_hours
    ADD CONSTRAINT uc_opening_hours_open_and UNIQUE (open_and);

ALTER TABLE public.opening_hours
    ADD CONSTRAINT uc_opening_hours_opening_time UNIQUE (opening_time);