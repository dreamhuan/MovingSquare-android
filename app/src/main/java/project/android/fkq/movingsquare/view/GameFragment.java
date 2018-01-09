package project.android.fkq.movingsquare.view;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import project.android.fkq.movingsquare.adapt.PuzzleAdapter;
import project.android.fkq.movingsquare.bean.PuzzleImg;
import project.android.fkq.movingsquare.R;


public class GameFragment extends Fragment implements onRefresh {


    private PuzzleImg[] puzzleImgs = {
            new PuzzleImg(R.drawable.a1, "铃仙·优昙华院·因幡", ""),
            new PuzzleImg(R.drawable.a2, "博丽灵梦", ""),
            new PuzzleImg(R.drawable.a3, "比那名居天子", ""),
            new PuzzleImg(R.drawable.a4, "八云紫", ""),
            new PuzzleImg(R.drawable.a5, "古明地觉", ""),
            new PuzzleImg(R.drawable.a6, "帕秋莉·诺蕾姬", ""),
            new PuzzleImg(R.drawable.a7, "蕾米莉亚·斯卡雷特", ""),
            new PuzzleImg(R.drawable.a8, "蓬莱山辉夜", ""),
            new PuzzleImg(R.drawable.a9, "洩矢诹访子", ""),
            new PuzzleImg(R.drawable.a10, "月球一家", "")
    };

    private List<PuzzleImg> puzzleImgList = new ArrayList<>();
    private PuzzleAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initIntro();
        initImgs();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PuzzleAdapter(puzzleImgList);
        recyclerView.setAdapter(adapter);

        swipeRefresh = getActivity().findViewById(R.id.swipe_refresh);
        swipeRefresh.setEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initIntro() {
        puzzleImgs[0].setIntro("铃仙·优昙华院·因幡是只和其它妖兽气质大不相同的妖怪兔。她身体修长，步姿端正，不像妖兽。在妖兽之中算是活动缓慢。虽是妖兽，却从不袭击人类。相反会避开人类。有着很长耳朵和头发。总的来说，是只与众不同的妖怪兔。\n" +
                "\n" +
                "据说一直看着她的红眼会让人发狂，而且她的声音，要听也听不进去，相反在远处有时会听到在耳边说话。因为这么让人厌恶，几乎无法和她对话。\n" +
                "\n" +
                "平时住在永远亭，在那里行动不明。有时也会来村庄售药。带着一堆怪药出现在村庄是出了名的（例如一些很苦的药）\n" +
                "\n" +
                "名片\n" +
                "原名：鈴仙·優曇華院·イナバ （レイセン・うどんげいん・イナバ，Reisen Udongein Inaba，铃仙·优昙华院·因幡）\n" +
                "\n" +
                "昵称：大兔子、铃仙\n" +
                "\n" +
                "种族：月兔\n" +
                "\n" +
                "住所：永远亭\n" +
                "\n" +
                "职业：辉夜的宠物、永琳的学徒\n" +
                "\n" +
                "能力：操纵波长程度的能力\n" +
                "\n" +
                "萌属性：兔娘、兔耳、兔尾、红瞳\n" +
                "\n\n");
        puzzleImgs[1].setIntro("《东方Project》的主角，几乎在每一作之中均有出现。\n" +
                "\n" +
                "博丽神社的巫女，名义上的幻想乡管理者。\n" +
                "\n" +
                "天生拥有不可思议的幸运和敏锐，以及许多能力，不过修行不足。\n" +
                "\n" +
                "不相信努力会有回报，讨厌修炼，缺乏危机感。\n" +
                "\n" +
                "每天就是在神社里面打扫和悠闲地喝茶。\n" +
                "\n" +
                "不过每次一旦发生异变，就会急急忙忙赶着去调查。\n" +
                "\n" +
                "退治妖怪的时候会非常严厉，但是在没有工作需要的时候对妖怪人类也是一视同仁。\n" +
                "\n" +
                "符卡多以“结界”、“阴阳”、“封印”等为主题。\n" +
                "\n" +
                "代表形象为阴阳玉，武器是阴阳玉和符纸。\n" +
                "\n" +
                "常见的二次设定有贪钱（一设里也有一定程度）、无节操等等。\n" +
                "\n" +
                "名片\n" +
                "原名：博麗 霊夢（はくれい れいむ，Hakurei Reimu，博丽灵梦）\n" +
                "\n" +
                "昵称：无节操，红白，城管\n" +
                "\n" +
                "年龄：大约是少女的年龄\n" +
                "\n" +
                "种族：人类\n" +
                "\n" +
                "住所：博丽神社\n" +
                "\n" +
                "职业：巫女\n\n");
        puzzleImgs[2].setIntro("居住在天界的天人，比那名居一族的大小姐。\n" +
                "\n" +
                "能够镇压和引发地震，并能操纵要石和使用绯想之剑。\n" +
                "\n" +
                "性格我行我素。\n" +
                "\n" +
                "因为对天界的生活感到无聊，于是引发了异变。" +
                "\n\n" +
                "原名：比那名居 地子(ひななゐ ちこ，Hinanawi Chiko)→比那名居 天子(ひななゐ てんし，Hinanawi Tenshi)\n" +
                "\n" +
                "昵称：Momoko（桃子）、M子\n" +
                "\n" +
                "年龄：\n" +
                "\n" +
                "种族：人类→天人(不良天人)\n" +
                "\n" +
                "身高：较高\n" +
                "\n" +
                "住所：幻想乡→有顶天\n" +
                "\n" +
                "职业：\n" +
                "\n" +
                "能力：操纵大地程度的能力\n" +
                "\n" +
                "萌属性：大小姐、蓝发、红瞳、桃子饰品的帽子");
        puzzleImgs[3].setIntro("资历和力量非常强大，有极高的智力，总是了解一切的样子。她被称为妖怪贤者，千年前幻想乡的创始人之一。作为少数知道幻想乡本质的妖怪，对幻想乡也极端地珍爱。\n" +
                "\n" +
                "她的主要活动时间是傍晚到半夜，白天则一直睡觉，一天能睡12个小时，因此可以说是除傍晚到半夜以外都不活动......属于典型的妖怪。她说她会在冬天冬眠（冬眠前存贮人类），春天醒来。不过由于不知道她冬天一直在哪里，所以无法判断真伪。\n" +
                "\n" +
                "她基本上不会自己动手，所有杂事都会推给她的妖兽式神八云蓝。尤其是白天和冬季，紫在睡觉的时候，会把事情都交给式神处理，这只式神会代理紫的一切行动。有时候也会用很特别的方法关心式神。\n" +
                "\n" +
                "还有就是她有好多同是活了好久的妖怪朋友。栖宿在冥界的西行寺幽幽子、鬼之伊吹萃香等等。她的朋友几乎都是些最强等级的妖怪。可是跟风见幽香除了经常战斗外没什么特别的关系（二设）。友人全是万年萝莉（萝莉控无误）。但是因为其无法理解的性格导致除了博丽灵梦，一般没有人会认真和她相处\n" +
                "\n" +
                "似乎和在现世的人类秘封俱乐部成员玛艾露贝莉·赫恩有类似庄生梦蝶的关系。\n" +
                "\n" +
                "弹幕名多以相对事物为主题。\n" +
                "\n" +
                "隙间妖怪， 这一种族只由她一人组成，平常都待在她的隙间里面。\n" +
                "\n" +
                "两次月面战争的发动者。\n" +
                "\n\n" +
                "原名：八云 紫（やくも ゆかり，Yakumo Yukari，八云紫）\n" +
                "\n" +
                "昵称：紫妈、紫大人、永远的十七岁、紫妹\n" +
                "\n" +
                "年龄：17岁又N个月其实至少1200..anghhkjl;l'klhjhgfsdfhjkl;' lkhjfcxsdffhjkhl;lkjhgfsdhjkl;l\n" +
                "\n" +
                "种族：隙间妖怪（紫是一个人一个种族的角色）\n" +
                "\n" +
                "身高：较高\n" +
                "\n" +
                "住所：她的家和博丽神社一样，建立在幻想乡和外面世界之间的境界上，没人见过那建筑物的样子，有人说她的家在外面的世界。\n" +
                "\n" +
                "职业：妖怪贤闲咸者\n" +
                "\n" +
                "能力：操纵境界的能力\n" +
                "\n" +
                "萌属性：伞、扇子、金发、御姐、金瞳、紫瞳、永远的十七岁\n" +
                "\n\n");
        puzzleImgs[4].setIntro("古明地觉是地灵殿的主人、古明地恋的姐姐，拥有读心的能力。\n" +
                "\n" +
                "同时是地底都市遗迹里残留着的怨灵的管理者。\n" +
                "\n" +
                "在灼热地狱遗址上建立起了地灵殿，并在那里居住了下来。\n" +
                "\n" +
                "因为她能够读取他人心中的想法，在她的面前没有秘密可言。\n" +
                "\n" +
                "不管是任何妖怪，连怨灵都为之感到恐惧。\n" +
                "\n" +
                "但是，相反因为能读心而受到那些不会说话的动物们的喜爱。\n" +
                "\n" +
                "因为宠物的增多，导致灼热地狱遗迹无法完美的管理，最后只得把很多管理事项交由宠物们去做。\n" +
                "\n" +
                "代表形象是“觉之眼”。\n" +
                "\n" +
                "符卡多以“回忆”或“心理活动”作为主题。\n" +
                "\n\n" +
                "原名：古明地さとり（こめいじさとり，Komeiji Satori，古明地觉）\n" +
                "\n" +
                "昵称：小五、小五萝莉、⑤\n" +
                "\n" +
                "种族：妖怪（觉）\n" +
                "\n" +
                "身高：偏矮\n" +
                "\n" +
                "住所：地灵殿\n" +
                "\n" +
                "能力：可以读心程度的能力\n" +
                "\n" +
                "萌属性：姐姐、紫发、水手袜、万年萝莉" +
                "\n\n");
        puzzleImgs[5].setIntro("帕秋莉是居住于红魔馆的魔法使。\n" +
                "\n" +
                "她是大小姐蕾米莉亚的好朋友，是个大概有100岁的魔女。\n" +
                "\n" +
                "居住在幻想乡中藏书最多的大图书馆——红魔馆地下图书馆中。\n" +
                "\n" +
                "喜欢读书，并且会使用七曜魔法。\n" +
                "\n" +
                "她平常总待在大图书馆里，患有哮喘、贫血，体质虚弱，因此在肉搏战中非常劣势。\n" +
                "\n" +
                "身体能力比人类还弱，不过她压倒性的魔法攻击可以弥补这一点。\n" +
                "\n" +
                "她无论什么时候都拿着书，并将书视为自己的一部分，离开书便无法生活。\n" +
                "\n" +
                "其符卡多数以七曜作为符名。\n" +
                "\n\n" +
                "原名：パチュリー・ノーレッジ（Patchouli Knowledge，帕秋莉・诺蕾姬）\n" +
                "\n" +
                "昵称：姆Q，帕琪\n" +
                "\n" +
                "年龄：大于一百岁\n" +
                "\n" +
                "种族：魔女、魔法使\n" +
                "\n" +
                "《萃梦想》、《绯想天》中为魔女，《地灵殿》、《求闻史纪》中为魔法使\n" +
                "此处的魔法使不同于魔理沙，指的是种族而非职业，是妖怪的一种\n" +
                "住所：红魔馆地下的大图书馆里\n" +
                "\n" +
                "职业：魔法使\n" +
                "\n" +
                "萌属性：紫发，宅女\n" +
                "\n\n");
        puzzleImgs[6].setIntro("蕾米莉亚是500岁的吸血鬼领主，夜之王。\n" +
                "\n" +
                "她是红魔馆的主人，芙兰朵露的姐姐。\n" +
                "\n" +
                "萝莉体型，身穿粉红色的洋装。\n" +
                "\n" +
                "作为红魔馆的主人，和一般的贵族一样注重威严和体面。\n" +
                "\n" +
                "但性格却跟外表一样，非常任性和孩子气。\n" +
                "\n" +
                "她拥有“操纵命运程度的能力”，似乎会使被影响者有很高概率遇上珍奇的事。\n" +
                "\n" +
                "符卡多以红色为主题。\n" +
                "\n\n" +
                "原名：レミリア·スカーレット（Remilia Scarlet，Remiria-Sukāretto，蕾米莉亚·斯卡蕾特）\n" +
                "\n" +
                "昵称：蕾咪（レミィ）、大小姐、姐姐、蕾米莉亚·抱头蹲防·斯卡蕾特\n" +
                "\n" +
                "年龄：500岁以上\n" +
                "\n" +
                "种族：吸血鬼、恶魔\n" +
                "\n" +
                "身高：矮（ZUN描述：比10岁孩子的身高还低）\n" +
                "\n" +
                "住所：红魔馆\n" +
                "\n" +
                "能力：\n" +
                "\n" +
                "運命を操る程度の能力\t　操纵命运程度的能力\n" +
                "萌属性：萝莉、腹黑、傲娇、大小姐、抱头蹲防\n" +
                "\n\n");
        puzzleImgs[7].setIntro("辉夜原本是生活在月宫的公主。因为利用自己的能力让八意永琳制作出不死之药——蓬莱之药，并服用了，因而触犯禁忌而被流放到地面上。她感到了对曾在地上照顾过她的人类们的依恋与感恩，以及回到月球后可能的种种不便。同时月的使者的首领八意永琳因为对辉夜心怀愧疚，并且深知辉夜回到月球也不能正常生活（沾染了人间的污秽），于是背叛了月都，背叛了同行的使者救下了辉夜。并在这片竹林里设下了永远亭这个居所（由辉夜对永远亭使用了永远的魔法），二人过着隐居的生活。\n" +
                "\n" +
                "直到永夜异变的夜晚，地面的人类和妖怪打进了永远亭。辉夜看到了地上的人类妖怪之间互相协助亲密无间十分融洽，并感到十分羡慕。同时觉得自己躲躲藏藏的生活愚蠢至极。于是她撤掉了永远的魔法，并且开放了永远亭与外界的联系。并且积极的融入到幻想乡之中。\n" +
                "\n\n" +
                "原名：蓬莱山輝夜（ほうらいさん かぐや，Houraisan Kaguya，蓬莱山辉夜）\n" +
                "\n" +
                "昵称：NEET姬、蓬莱NEET、蓬莱山家具屋、蓬莱山赫映\n" +
                "\n" +
                "年龄：不老不死（有一说为酒醉后的ZUN曾提过，辉夜与永琳的年龄以亿为单位）\n" +
                "\n" +
                "种族：月人(《文花帖》中自称人类 )\n" +
                "\n" +
                "身高：中等\n" +
                "\n" +
                "住所：永远亭\n" +
                "\n" +
                "能力：\n" +
                "\n" +
                "永遠と須臾を操る能力\t　操纵永远和须臾程度的能力\n" +
                "萌属性：公主、不老不死、黑长直、腹黑（二设）\n" +
                "\n\n");
        puzzleImgs[8].setIntro("守矢神社真正供奉的神明\n" +
                "\n" +
                "在遠古時候擁有非常恐怖的信仰心，作為神的同時甚至作為王建立了一個王國\n" +
                "\n" +
                "因為在和神奈子的戰鬥中敗北而投降，將王國交出\n" +
                "\n" +
                "不過因為神奈子無法得到王國人們的信仰，而變成了在神奈子背後一起治理著王國的情況\n" +
                "\n" +
                "隨著時間的流逝，諏訪子漸漸的被人們所遺忘，記得諏訪子真名的人，也幾乎沒有了\n" +
                "\n" +
                "此時神奈子決定將守矢神社遷到幻想鄉內，從此諏訪子在幻想鄉內開始了新的生活\n" +
                "\n" +
                "諏訪子是早苗遙遠的祖先，不過早苗對此卻完全不知情\n" +
                "\n\n" +
                "名字：洩矢諏訪子（もりや すわこ，Moriya Suwako，洩矢諏訪子）\n" +
                "\n" +
                "種族：神明（土著神）\n" +
                "\n" +
                "能力：創造坤（地）程度的能力\n" +
                "\n" +
                "年齡：不詳，推算約有2000年以上\n" +
                "\n" +
                "身高：較矮\n" +
                "\n" +
                "住所：守矢神社\n" +
                "\n" +
                "職業：神明\n" +
                "\n" +
                "萌點：蘿莉" +
                "\n\n");
        puzzleImgs[9].setIntro("这本来应该是一个平静安宁的夜晚。\n" +
                "时值幻想乡的满月之夜，月亮和平常看起来没有什么不同。\n" +
                "可是，看似完整的满月，却似乎不是真实的。\n" +
                "对于人类来说，月亮是不是真实的，没有什么太大的影响。\n" +
                "可是对于依赖满月的力量的妖怪们来说，没有满月，就意味失去力量，这可是攸关生死的问题。\n" +
                "“这是异变”，幻想乡的妖怪们如此判定着，纷纷找上了人类作为自己的搭档出发调查。\n" +
                "为了解决异变和取回满月，人类和妖怪联手将夜晚——停止了。\n" +
                "于是，这个晚上，就成为了——永夜。\n" +
                "\n");
    }

    @Override
    public void refresh() {
        new Thread(() -> {
            try {
                // 强行网络延迟1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getActivity().runOnUiThread(() -> {
                initImgs();
                adapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            });
        }).start();
    }

    private void initImgs() {
        puzzleImgList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(puzzleImgs.length);
            puzzleImgList.add(puzzleImgs[index]);
        }
    }
}
