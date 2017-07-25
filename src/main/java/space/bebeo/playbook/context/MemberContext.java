package space.bebeo.playbook.context;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
public class MemberContext {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer age;

}
