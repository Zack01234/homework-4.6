create table cars (   id serial primary key,
                      brand text,
                      model text,
                      price money
);
create table person (   id serial primary key,
                        name text,
                        age integer,
                        driving_license boolean,
                        car integer references cars (id)
)