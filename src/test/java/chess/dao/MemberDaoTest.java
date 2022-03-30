package chess.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberDaoTest {

    @Test
    void connection() {
        final MemberDao memberDao = new MemberDao();
        final Connection connection = memberDao.getConnection();
        assertThat(connection).isNotNull();
    }

    @Test
    void save() {
        final MemberDao memberDao = new MemberDao();
        memberDao.save(new Member("sudal", "수달"));
    }

    @Test
    void findById() {
        final MemberDao memberDao = new MemberDao();
        final Member member = new Member("sudal", "수달");
        memberDao.findById(member.getId());
        System.out.println(member);
    }

    @Test
    void findWithRoleById() {
        final MemberDao memberDao = new MemberDao();
        final Member member = new Member("sudal", "수달");
        Member find = memberDao.findWithRoleById(member.getId());
        System.out.println(find);
    }


    @Test
    void findAll() {
        final MemberDao memberDao = new MemberDao();
        final List<Member> members = memberDao.findAll();
        assertThat(members).isNotEmpty();
    }
}