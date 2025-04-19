//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    /*
    user, question, answer (comments)

    StackOverflow --> List<Users>, List<Question>, map<Tag,List<Question>>
    addQuestion(User,String content), addAnswer(User,Question), addComment(User, IPost),
    vote(Ipost),searchByUser(User),seachByTag(Tag),searchByKeyword(String)
    createUser()

    User --> name,email, List<Question>, reputationScore

    IPost -> Answer and Question

    Question --> String content, vote, list<Answer>, User, list<Comment>, list<Tag>

    Answer --> Question, vote, User, list<Comment>

    Comment --> Ipost, User

    Tag --> id, name

    DP
    Singleton on StackOverflow
     */
        // good online article with code and DP and principle usage
        //https://medium.com/@mohitmandlecha7256/stackoverflow-lld-in-java-19f67c506a37
    }
}