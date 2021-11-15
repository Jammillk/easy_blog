alter table tb_config
    drop primary key;
alter table tb_config
    add config_id bigint not null primary key auto_increment first ;
