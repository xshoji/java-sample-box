FROM centos:6.9

# timezone変更
RUN cp -p /usr/share/zoneinfo/Japan /etc/localtime

RUN yum update -y && yum clean all

# Linux(CentOS7)でSSHを利用する。 http://qiita.com/sango/items/816136188387221f05b3
RUN yum -y install \
  sudo \
  openssh-server \
  wget \
;


# Install httpie
WORKDIR /usr/local/src
RUN wget https://bootstrap.pypa.io/get-pip.py && \
  python get-pip.py && \
  pip install "httpie" \
;


# install java
WORKDIR /usr/local/src
# Oracle JDKを一発でダウンロードするwgetのオプション http://qiita.com/ajis_ka/items/b3d9030e2aaf199a20b7
# CentOS6.xにOracleのJDK8をインストールする http://qiita.com/Sa2/items/8ba501294df745be8c78
RUN wget --no-cookies \
         --no-check-certificate \
         --header "Cookie: oraclelicense=accept-securebackup-cookie" \
         "http://download.oracle.com/otn-pub/java/jdk/8u102-b14/jdk-8u102-linux-x64.rpm" \
    && rpm -ivh jdk-8u102-linux-x64.rpm \
;
# CentOSにJava（JDK）をRPMでインストール+バージョン変更について http://www.task-notes.com/entry/20150602/1433214000
ENV JAVA_HOME /usr/java/default
ENV JAVA_BIN ${JAVA_HOME}/bin



# Install maven
# maven3 (3.2.x) を CentOS/RedHat にインストールする手順 | WEB ARCH LABO http://weblabo.oscasierra.net/install-maven-32-redhat/
RUN wget http://ftp.yz.yamagata-u.ac.jp/pub/network/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz \
    && tar zxvf apache-maven-3.5.0-bin.tar.gz \
    && mv apache-maven-3.5.0 /opt/apache-maven-3.5.0 \
;
ENV M3_HOME /opt/apache-maven-3.5.0
ENV M3 ${M3_HOME}/bin

ENV PATH ${M3}:${JAVA_BIN}/bin:$PATH

EXPOSE 22 8080

CMD ["/usr/sbin/sshd", "-D"]
