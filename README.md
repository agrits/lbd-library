# Build
mvn clean package && docker build -t pl.fis.artur.kasza/library .

# RUN

docker rm -f library || true && docker run -d -p 8080:8080 -p 4848:4848 --name library pl.fis.artur.kasza/library 