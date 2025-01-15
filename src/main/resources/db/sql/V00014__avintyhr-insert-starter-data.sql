--liquibase formatted sql

--changeset laufer:14 dbms:postgresql
SET session_replication_role = 'replica';

--Employee sample data
INSERT INTO public.employee (employee_id,"name",email,phone,position_id,start_date_of_work,end_date_of_work) VALUES
     ('5e1d7100-cf8b-493e-bdd5-f87fa79f29e8'::uuid,'Annemarije Maanenschijn','annemarije.maanenschijn@email.com','06-12610076 ','0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'1996-04-01 00:00:00',NULL),
     ('fc6cb2b7-a943-430e-b1dd-55cf74ebbcce'::uuid,'Bartjan van der Cozijne','bartjan.van.der.cozijne@email.com','06-74664338 ','0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'2008-05-24 00:00:00',NULL),
     ('1d0ef529-78ca-4289-9e36-b6dbd8f38e24'::uuid,'Dieneke Nieuwlaar','dieneke.nieuwlaar@email.com','06-30442380 ','0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'2010-03-27 00:00:00',NULL),
     ('c1c673d3-1266-48f9-aa8a-266068c92f3d'::uuid,'Marjolijn Kraaijenbeld','marjolijn.kraaijenbeld@email.com','06-47164954 ','10f4b948-71f7-407e-a2bc-2b2b5b1119b2'::uuid,'2010-10-06 00:00:00',NULL),
     ('ecfcc798-7e8b-40e8-8486-cfe268236405'::uuid,'Klaartje Seuper','klaartje.seuper@email.com','06-10975405 ','10f4b948-71f7-407e-a2bc-2b2b5b1119b2'::uuid,'2010-10-13 00:00:00','2018-01-01 00:00:00'),
     ('39058dc1-3237-4e9d-9169-1130508cf6b4'::uuid,'Remko Sikke','remko.sikke@email.com','06-38252718 ','8c932aa0-7333-4af8-aab1-7d40c856869f'::uuid,'2010-11-20 00:00:00',NULL),
     ('31a37559-a327-40d0-9958-0622470f42f1'::uuid,'Fien Albertboer','fien.albertboer@email.com','06-68544911 ','ba5d2bc6-a20a-449f-ad71-0bff858c30c4'::uuid,'2012-06-04 00:00:00','2023-04-14 00:00:00'),
     ('e529bbe6-d29d-427e-b2bf-40d1258460ab'::uuid,'Ellen Lugtigheid','ellen.lugtigheid@email.com','06-67769325 ','ba5d2bc6-a20a-449f-ad71-0bff858c30c4'::uuid,'2017-09-11 00:00:00',NULL),
     ('164710c0-25e1-4786-9ce5-e8c1a037c8c7'::uuid,'Floris-Jan Broekotte','floris-jan.broekotte@email.com','06-90069665 ','0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'2010-11-27 00:00:00','2015-03-15 00:00:00'),
     ('fc7d0fc8-782b-40b7-89e9-5c3160033667'::uuid,'Wim Schultnik','wim.schultink@email.com','06-84435158 ','75d1f1fe-b2e9-4134-8140-26c51ae9413f'::uuid,'2021-07-11 00:00:00','2041-01-01 00:00:00');
INSERT INTO public.employee (employee_id,"name",email,phone,position_id,start_date_of_work,end_date_of_work) VALUES
     ('5c25affb-9f0d-4beb-96a9-779e1d60893a'::uuid,'Joosje van Kempen','joosje.van.kempen@email.com','06-99591160 ','75d1f1fe-b2e9-4134-8140-26c51ae9413f'::uuid,'2020-08-13 00:00:00',NULL),
     ('2216c350-b859-4764-be3d-1006ff75efa8'::uuid,'Thea Westerbeek van Eerten','thea.westerbeek.van.eerten@email.com','06-45164776 ','0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'1951-12-25 00:00:00','2024-12-25 00:00:00'),
     ('06eb4780-9c4a-4210-87fc-f674c5d6c330'::uuid,'Ankie Steenmets','ankie.steenmets@email.com
','06-74365158 ','358f1133-d322-4491-b544-97a7791a7457'::uuid,'2001-09-11 00:00:00',NULL);

--Department sample data
INSERT INTO public.department (department_id,"name",manager) VALUES
     ('9b2fcfb0-45c9-4ab7-b64e-90c049e2b290'::uuid,'Corporate','5e1d7100-cf8b-493e-bdd5-f87fa79f29e8'::uuid),
     ('6689e5f5-acc2-4a69-a46e-f516e4da4360'::uuid,'Applied Sciences','fc6cb2b7-a943-430e-b1dd-55cf74ebbcce'::uuid),
     ('46e02e9f-d719-433b-b766-51912c4a7197'::uuid,'Marketing','1d0ef529-78ca-4289-9e36-b6dbd8f38e24'::uuid),
     ('a5f6baf9-3af6-4565-aeaf-1c748419c468'::uuid,'Department Archeology','164710c0-25e1-4786-9ce5-e8c1a037c8c7'::uuid),
     ('91e78070-d9c9-4816-84d1-251784291f82'::uuid,'Internal Affairs','2216c350-b859-4764-be3d-1006ff75efa8'::uuid);

--Position sample data
INSERT INTO public."position" (position_id,department_id,"name") VALUES
     ('0e7d9844-b138-4ef3-b3cd-cd71a59b9883'::uuid,'9b2fcfb0-45c9-4ab7-b64e-90c049e2b290'::uuid,'Department Head'),
     ('10f4b948-71f7-407e-a2bc-2b2b5b1119b2'::uuid,'6689e5f5-acc2-4a69-a46e-f516e4da4360'::uuid,'Lead Researcher'),
     ('8c932aa0-7333-4af8-aab1-7d40c856869f'::uuid,'6689e5f5-acc2-4a69-a46e-f516e4da4360'::uuid,'Associate Researcher'),
     ('ba5d2bc6-a20a-449f-ad71-0bff858c30c4'::uuid,'46e02e9f-d719-433b-b766-51912c4a7197'::uuid,'Senior Salesperson'),
     ('4febcbb0-8849-475b-83f7-4053629b1e3e'::uuid,'46e02e9f-d719-433b-b766-51912c4a7197'::uuid,'Junior Marketing Consultant'),
     ('75d1f1fe-b2e9-4134-8140-26c51ae9413f'::uuid,'a5f6baf9-3af6-4565-aeaf-1c748419c468'::uuid,'Associate Archeologist'),
     ('358f1133-d322-4491-b544-97a7791a7457'::uuid,'91e78070-d9c9-4816-84d1-251784291f82'::uuid,'Corporate Liason');

--Appointment sample data
INSERT INTO public.employee_appointment (appointment_id,employee_id) VALUES
     ('484d6adb-0b10-44e4-94dd-cc8d634b6eed'::uuid,'39058dc1-3237-4e9d-9169-1130508cf6b4'::uuid),
     ('484d6adb-0b10-44e4-94dd-cc8d634b6eed'::uuid,'e529bbe6-d29d-427e-b2bf-40d1258460ab'::uuid);

SET session_replication_role = DEFAULT;