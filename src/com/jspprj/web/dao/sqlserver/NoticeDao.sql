SELECT * FROM NOTICES

--INSERT INTO NOTICES(CODE, TITLE, WRITER, CONTENT) VALUES(1041, '안녕하세요', 'PPAP', '펭파잉애플애플팬')--

CREATE VIEW NOTICES_VIEW
AS
SELECT N.*,COUNT(C.CODE) AS CMTCNT
FROM
NOTICES N LEFT OUTER JOIN COMMENTS C ON N.CODE = C.NOTICECODE 
GROUP BY N.Code, N.Title,N.Writer,N.Content,N.RegDate,N.Hit;

SELECT ISNULL(MAX(CAST(CODE AS INT)),1) FROM NOTICES

SELECT * from NOTICES_VIEW;

SELECT * FROM(
	SELECT
	ROW_NUMBER() OVER(ORDER BY REGDATE DESC) NUM,
	NOTICES_VIEW.*FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
)N
WHERE NUM BETWEEN 1 AND 10;

-- get Count query
SELECT  COUNT(*) FROM(
	SELECT
	ROW_NUMBER() OVER(ORDER BY REGDATE DESC) NUM,
	NOTICES_VIEW.*FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
)N
