package be.cegeka.bibliothouris.domain.members;

/**
 * Created by jensde on 19/02/2017.
 */
public class Member {
    private final String name;
    private final String inss;

    public Member(String name, String inss) {
        this.name = name;
        this.inss = inss;
    }

    public String getName() {
        return name;
    }

    public String getInss() {
        return inss;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        return inss != null ? inss.equals(member.inss) : member.inss == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (inss != null ? inss.hashCode() : 0);
        return result;
    }
}
