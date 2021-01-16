CREATE DATABASE CMS
GO
SELECT * FROM dbo.Member

UPDATE dbo.Member SET role = 'user'
WHERE member_id =28


DELETE dbo.Member WHERE member_id=17