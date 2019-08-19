# Build
mvn clean package && docker build -t pl.fis.artur.kasza/library .

# Mock

To mock the database please execute ./mock.sh from src\main\resources\library-sqls.

Edit credentials as necessary, defaults are:
- User: postgres
- Password: toor

# RUN

docker rm -f library || true && docker run -d -p 8080:8080 -p 4848:4848 --name library pl.fis.artur.kasza/library 
