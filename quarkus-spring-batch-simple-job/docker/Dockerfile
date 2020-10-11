# Base image
FROM oracle/graalvm-ce

RUN yum install -y \
    curl \
    less \
    vim \
    zip \
    git \
    unzip \
    java \
;

RUN curl -OL https://archive.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz \
  && tar zxvf apache-maven-3.5.2-bin.tar.gz \
  && rm apache-maven-3.5.2-bin.tar.gz \
  && mv ./apache-maven-3.5.2 /usr/lib \
;

RUN curl -OL https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java8-linux-amd64-20.2.0.tar.gz \
  && tar zxvf graalvm-ce-java8-linux-amd64-20.2.0.tar.gz \
  && rm graalvm-ce-java8-linux-amd64-20.2.0.tar.gz \
  && mv ./graalvm-ce-java8-20.2.0 /usr/lib \
;

#RUN GRAALVM_PKG=https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.2.0/graalvm-ce-java8-linux-amd64-20.2.0.tar.gz \
#  && GRAALVM_VERSION=20.2.0 \
#  && JAVA_VERSION=java8 \
#  && /bin/sh -c set -eux \
#  && curl --fail --silent --location --retry 3 ${GRAALVM_PKG}  | gunzip | tar x -C /opt/ \
#  && mkdir -p "/usr/java" \
#  && ln -sfT "$JAVA_HOME" /usr/java/default \
#  && ln -sfT "$JAVA_HOME" /usr/java/latest \
#  && for bin in "$JAVA_HOME/bin/"*; do base="$(basename \"$bin\")"; [ ! -e "/usr/bin/$base" ]; alternatives --install "/usr/bin/$base" "$base" "$bin" 20000; done \
#  && chmod +x /usr/local/bin/gu \
#;

COPY ./docker/bashrc /root/.bashrc

CMD ["/bin/bash"]
