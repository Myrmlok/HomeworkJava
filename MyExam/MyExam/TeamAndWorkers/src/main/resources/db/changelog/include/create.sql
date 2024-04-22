
create table _role(
    id int primary key AUTO_INCREMENT,
    _name varchar(256)
);
create table _worker(
    id bigint primary key AUTO_INCREMENT,
    email varchar(256) unique,
    phone varchar(20) unique,
    role_id int,
    FOREIGN KEY (role_id) references _role(id),
    team_id bigint
);
create table _team(
                      id bigint primary key AUTO_INCREMENT,
                      _name varchar(256),
                      boss_id bigint,
                      FOREIGN KEY (boss_id) references _worker(id) ON DELETE SET NULL
);

ALTER TABLE _worker
    ADD FOREIGN KEY (team_id) references _team(id) ON DELETE set null;

create table taskStatus(
                           id int primary key AUTO_INCREMENT,
                           _name varchar(256)
);

create table _task(
                      id bigint primary key AUTO_INCREMENT,
                      _name varchar(256),
                      beginTime datetime,
                      endTime datetime,
                      boss_id bigint,
                      FOREIGN KEY (boss_id) references _worker(id) ON DELETE SET NULL,
                      worker_id bigint,
                      FOREIGN KEY (worker_id) references _worker(id) ON DELETE SET NULL,
                      status_id int,
                      FOREIGN KEY (status_id) references task_status(id)
);
create table blockFile(
                          id bigint primary key AUTO_INCREMENT,
                          count int,
                          bytes  mediumblob,
                          filename varchar(256),
                          task_id bigint,
                          foreign key (task_id) references _task(id) ON DELETE CASCADE
);
create table blockText(
                          id bigint primary key AUTO_INCREMENT,
                          count int,
                          text text,
                          task_id bigint,
                          foreign key (task_id) references _task(id) ON DELETE CASCADE
);
create table typeAnswer(
                           id int primary key AUTO_INCREMENT,
                           _name varchar(256)
);
create table blockAnswer(
                            id bigint primary key AUTO_INCREMENT,
                            count int,
                            limitations varchar(256),
                            about varchar(256),
                            type_id int,
                            foreign key (type_id) references type_answer(id)
);