Drop table zed02_partner_covarage;
Drop table zed01_partner;

Create table zed01_partner (
        partner_id number not null,
        name varchar2(255),
        doc_cnpj varchar2(200),
        owner_name varchar2(255),
        coordinate_lat number,
        coordinate_lng number,
         CONSTRAINT partner_pk PRIMARY KEY (partner_id),
         CONSTRAINT cnpj_unique UNIQUE (doc_cnpj));

Create table zed02_partner_covarage (
        partner_id  number not null,              
        coverage_id number not null,
        coordinate_lat number,
        coordinate_lng number,
		    FOREIGN KEY (partner_id)
        REFERENCES zed01_partner(partner_id)
        );


