package io.github.xshoji.guicecommandtool.command;

import com.google.inject.Inject;
import io.github.xshoji.guicecommandtool.dao.PersonDao;
import io.github.xshoji.guicecommandtool.entity.Person;
import org.kohsuke.args4j.Option;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DbCrudCommand extends Command {

    @Inject
    protected PersonDao personDao;

    @Option(name="-name",usage="Person.name",required=true)
    public String name;

    @Option(name="-nick",usage="Person.nickName")
    public String nickName;

    protected void doRun(String[] args) {

        Person person = new Person();
        Long personId = Long.valueOf(new SimpleDateFormat("YYYYMMddHHmmssSS").format(new Date()));
        person.setId(personId);
        person.setName(this.name);
        person.setNickName(this.nickName);

        this.systemOutPrintln();
        this.systemOutPrintln("[Info] Create");
        this.systemOutPrintln("  id   : " + person.getId());
        this.systemOutPrintln("  name : " + person.getName());
        this.systemOutPrintln("  nick : " + person.getNickName());
        this.personDao.save(person);
        this.systemOutPrintln();


        this.systemOutPrintln("[Info] findOne");
        Person personFound = this.personDao.find(personId);
        this.systemOutPrintln("  id   : " + personFound.getId());
        this.systemOutPrintln("  name : " + personFound.getName());
        this.systemOutPrintln("  nick : " + personFound.getNickName());
        this.systemOutPrintln();


        this.systemOutPrintln("[Info] Update");
        personFound.setName(personFound.getName() + "_edited");
        this.personDao.update(personFound);
        this.systemOutPrintln();


        this.systemOutPrintln("[Info] findAll");
        List<Person> persons = this.personDao.findAll();
        persons.forEach(p -> {
            this.systemOutPrintln("  id   : " + p.getId());
            this.systemOutPrintln("  name : " + p.getName());
            this.systemOutPrintln("  nick : " + p.getNickName());
            this.systemOutPrintln();
        });


        this.systemOutPrintln("[Info] Delete");
        this.systemOutPrintln("  id   : " + personFound.getId());
        this.personDao.delete(personFound);
        this.systemOutPrintln();


        this.systemOutPrintln("[Info] findAll");
        persons = this.personDao.findAll();
        persons.forEach(p -> {
            this.systemOutPrintln("  id   : " + p.getId());
            this.systemOutPrintln("  name : " + p.getName());
            this.systemOutPrintln("  nick : " + p.getNickName());
            this.systemOutPrintln();
        });
        this.systemOutPrintln();
    }
}