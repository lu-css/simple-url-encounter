-- The Stored URL

-- :name create-urls-table
-- :command :execute
-- :result :raw
-- :doc Create url table
create table urls (
  id              SERIAL primary key,
  code            varchar(10) unique,
  original        text,
  created_at      timestamp not null default current_timestamp
)

-- :name insert-url :! :n
-- :doc Insert a new encurted URL.
insert into urls (code, original)
values (:code, :original)

-- :name url-by-id :? :1
-- :doc Return a single URL using a code.
select * from urls
where code = :code
