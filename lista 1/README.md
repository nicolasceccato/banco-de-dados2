Com base no seguinte banco foram respondidas as questoes:
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2022-05-04 21:12:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16983)
-- Name: animais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.animais (
    nomeanimal character varying(20),
    codespecie integer,
    codanimal integer NOT NULL,
    codanimalpai integer,
    codanimalmae integer,
    dtnascanimal date
);


ALTER TABLE public.animais OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16986)
-- Name: consultas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultas (
    codanimal integer NOT NULL,
    matricula integer NOT NULL,
    data date NOT NULL,
    diagnosticoconsulta character varying(100),
    codconsulta integer NOT NULL
);


ALTER TABLE public.consultas OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16989)
-- Name: especies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especies (
    codespecie integer NOT NULL,
    nomeespecie character varying(20),
    expectativaespecie integer
);


ALTER TABLE public.especies OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16992)
-- Name: funcionarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionarios (
    matricula integer NOT NULL,
    nome character varying(20),
    endereco character varying(20),
    email character varying(20),
    crmv integer,
    especialidade character varying(30)
);


ALTER TABLE public.funcionarios OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16995)
-- Name: medicamentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medicamentos (
    codmedicamento integer NOT NULL,
    nomemedicamento character varying(20)
);


ALTER TABLE public.medicamentos OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16998)
-- Name: prescricao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prescricao (
    codconsulta integer NOT NULL,
    codmedicamento integer NOT NULL
);


ALTER TABLE public.prescricao OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 16983)
-- Dependencies: 200
-- Data for Name: animais; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.animais VALUES ('Glória', 1, 1, NULL, NULL, '2010-05-05');
INSERT INTO public.animais VALUES ('Vermelho', 1, 2, NULL, NULL, '2009-08-05');
INSERT INTO public.animais VALUES ('Juzz', 1, 3, 2, 1, '2015-05-07');
INSERT INTO public.animais VALUES ('Opalala', 1, 4, 2, 1, '2018-01-04');
INSERT INTO public.animais VALUES ('Branquinho', 2, 5, NULL, NULL, '2017-01-05');
INSERT INTO public.animais VALUES ('Quick', 2, 6, NULL, NULL, '2016-12-31');
INSERT INTO public.animais VALUES ('Morango', 2, 7, 5, 6, '2017-12-20');
INSERT INTO public.animais VALUES ('Chocolate', 2, 8, 5, 6, '2017-12-20');
INSERT INTO public.animais VALUES ('Salti', 2, 9, 5, 6, '2017-12-20');
INSERT INTO public.animais VALUES ('Jazz', 2, 10, 5, 6, '2018-02-28');
INSERT INTO public.animais VALUES ('Guto', 2, 11, 5, 6, '2018-02-28');
INSERT INTO public.animais VALUES ('Helio', 1, 12, 3, 1, '2018-03-01');
INSERT INTO public.animais VALUES ('Verduz', 2, 13, 8, 7, '2018-03-01');
INSERT INTO public.animais VALUES ('Janjão', 1, 14, 4, 13, '2019-01-12');


--
-- TOC entry 3020 (class 0 OID 16986)
-- Dependencies: 201
-- Data for Name: consultas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.consultas VALUES (1, 111, '2018-02-10', 'Dor de Barriga', 1);
INSERT INTO public.consultas VALUES (1, 222, '2018-02-11', 'Dor de Barriga', 2);
INSERT INTO public.consultas VALUES (7, 222, '2018-02-28', 'Hepatite B', 3);
INSERT INTO public.consultas VALUES (7, 222, '2018-03-01', 'Hepatite B', 4);
INSERT INTO public.consultas VALUES (2, 111, '2018-07-07', 'Unha encravada', 5);
INSERT INTO public.consultas VALUES (1, 333, '2018-03-20', 'Dor de Barriga', 6);
INSERT INTO public.consultas VALUES (8, 333, '2018-03-20', 'Indigestão', 7);
INSERT INTO public.consultas VALUES (10, 111, '2018-03-22', 'Indigestão', 8);


--
-- TOC entry 3021 (class 0 OID 16989)
-- Dependencies: 202
-- Data for Name: especies; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.especies VALUES (3, 'Mosquito', 1);
INSERT INTO public.especies VALUES (4, 'Cachorro', 6);
INSERT INTO public.especies VALUES (1, 'Hipopótamo', 11);
INSERT INTO public.especies VALUES (2, 'Coelho', 4);


--
-- TOC entry 3022 (class 0 OID 16992)
-- Dependencies: 203
-- Data for Name: funcionarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionarios VALUES (222, 'José de Oliveira', 'Rua Verde, 58', 'jose.oliveira@zoo.br', 555, 'pediatra');
INSERT INTO public.funcionarios VALUES (333, 'Ana Maria Ritz', 'Rua Azul, 12', 'ana.ritz@zoo.br', 184, 'pediatra');
INSERT INTO public.funcionarios VALUES (111, 'Valéria Ana Sá', 'Rua dos Limões, 586 ', 'valeria.sa@zoo.br', 152, 'clínica geral');


--
-- TOC entry 3023 (class 0 OID 16995)
-- Dependencies: 204
-- Data for Name: medicamentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.medicamentos VALUES (55, 'Zorá 5mg');
INSERT INTO public.medicamentos VALUES (588, 'Fliur');
INSERT INTO public.medicamentos VALUES (781, 'Benafler 80');


--
-- TOC entry 3024 (class 0 OID 16998)
-- Dependencies: 205
-- Data for Name: prescricao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prescricao VALUES (1, 55);
INSERT INTO public.prescricao VALUES (1, 781);
INSERT INTO public.prescricao VALUES (2, 781);
INSERT INTO public.prescricao VALUES (3, 588);
INSERT INTO public.prescricao VALUES (4, 588);
INSERT INTO public.prescricao VALUES (4, 55);
INSERT INTO public.prescricao VALUES (4, 781);


--
-- TOC entry 2869 (class 2606 OID 17002)
-- Name: animais animais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animais
    ADD CONSTRAINT animais_pkey PRIMARY KEY (codanimal);


--
-- TOC entry 2876 (class 2606 OID 17004)
-- Name: especies especies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especies
    ADD CONSTRAINT especies_pkey PRIMARY KEY (codespecie);


--
-- TOC entry 2878 (class 2606 OID 17006)
-- Name: funcionarios funcionarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (matricula);


--
-- TOC entry 2880 (class 2606 OID 17008)
-- Name: medicamentos medicamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicamentos
    ADD CONSTRAINT medicamentos_pkey PRIMARY KEY (codmedicamento);


--
-- TOC entry 2874 (class 2606 OID 17010)
-- Name: consultas pk_codconsulta; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT pk_codconsulta PRIMARY KEY (codconsulta);


--
-- TOC entry 2882 (class 2606 OID 17012)
-- Name: prescricao prescricao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescricao
    ADD CONSTRAINT prescricao_pkey PRIMARY KEY (codconsulta, codmedicamento);


--
-- TOC entry 2870 (class 1259 OID 17013)
-- Name: fki_especie; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_especie ON public.animais USING btree (codespecie);


--
-- TOC entry 2871 (class 1259 OID 17014)
-- Name: fki_mae; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_mae ON public.animais USING btree (codanimalmae);


--
-- TOC entry 2872 (class 1259 OID 17015)
-- Name: fki_pai; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_pai ON public.animais USING btree (codanimalpai);


--
-- TOC entry 2886 (class 2606 OID 17016)
-- Name: consultas consultas_codanimal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT consultas_codanimal_fkey FOREIGN KEY (codanimal) REFERENCES public.animais(codanimal);


--
-- TOC entry 2887 (class 2606 OID 17021)
-- Name: consultas consultas_matricula_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT consultas_matricula_fkey FOREIGN KEY (matricula) REFERENCES public.funcionarios(matricula);


--
-- TOC entry 2883 (class 2606 OID 17026)
-- Name: animais fk_especie; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animais
    ADD CONSTRAINT fk_especie FOREIGN KEY (codespecie) REFERENCES public.especies(codespecie);


--
-- TOC entry 2884 (class 2606 OID 17031)
-- Name: animais fk_mae; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animais
    ADD CONSTRAINT fk_mae FOREIGN KEY (codanimalmae) REFERENCES public.animais(codanimal);


--
-- TOC entry 2885 (class 2606 OID 17036)
-- Name: animais fk_pai; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.animais
    ADD CONSTRAINT fk_pai FOREIGN KEY (codanimalpai) REFERENCES public.animais(codanimal);


--
-- TOC entry 2888 (class 2606 OID 17041)
-- Name: prescricao prescricao_codmedicamento_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescricao
    ADD CONSTRAINT prescricao_codmedicamento_fkey FOREIGN KEY (codmedicamento) REFERENCES public.medicamentos(codmedicamento);


-- Completed on 2022-05-04 21:12:01

--
-- PostgreSQL database dump complete
--
