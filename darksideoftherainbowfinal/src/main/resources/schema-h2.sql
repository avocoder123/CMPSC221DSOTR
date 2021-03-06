--
--  Create a table to hold customers!
create table public.album(
    album_id INTEGER PRIMARY KEY,
    album_name character  varying ,
    album_artist character varying,
    album_price numeric,
    album_genre character varying,
    album_number_of_tracks INTEGER,
    album_date_released character varying
);

drop sequence public.album_id_seq;

create sequence public.album_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;

create table public.application_user (
    user_id INTEGER PRIMARY KEY,
    username character  varying ,
    password character varying,
    is_admin boolean
);

drop sequence public.application_user_id_seq;

create sequence public.application_user_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;