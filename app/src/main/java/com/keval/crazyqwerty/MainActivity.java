package com.keval.crazyqwerty;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, bs;

    Button play;
    TextView input,output,timer;
    // website for dictionary   https://www.vocabulary.com/lists/191545
    // code for extracting dictionary https://ide.codingblocks.com/#/s/9127

    Integer yourScore = 0;
    TextView yourscoretext;

    ArrayList<String> seenWords = new ArrayList<>();
    ArrayList<String> seenMeanings = new ArrayList<>();

    String []words ={"abject","aberration","abjure","abnegation","abrogate","abscond","abstruse","accede","accost","accretion","acumen","adamant","admonish","adumbrate","adverse","advocate","affluent","aggrandize","alacrity","alias","ambivalent","amenable","amorphous","anachronistic","anathema","annex","antediluvian","antiseptic","apathetic","antithesis","apocryphal","approbation","arbitrary","arboreal","arcane","archetypal","arrogate","ascetic","aspersion","assiduous","atrophy","bane","bashful","beguile","bereft","blandishment","bilk","bombastic","cajole","callous","calumny","camaraderie","candor","capitulate","carouse","carp","caucus","cavort","circumlocution","circumscribe","circumvent","clamor","cleave","cobbler","cogent","cognizant","commensurate","complement","compunction","concomitant","conduit","conflagration","congruity","connive","consign","constituent","construe","contusion","contrite","contentious","contravene","convivial","corpulence","covet","cupidity","dearth","debacle","debauch","debunk","defunct","demagogue","denigrate","derivative","despot","diaphanous","didactic","dirge","disaffected","discomfit","disparate","dispel","disrepute","divisive","dogmatic","dour","duplicity","duress","eclectic","edict","ebullient","egregious","elegy","elicit","embezzlement","emend","emollient","empirical","emulate","enervate","enfranchise","engender","ephemeral","epistolary","equanimity","equivocal","espouse","evanescent","evince","exacerbate","exhort","execrable","exigent","expedient","expiate","expunge","extraneous","extol","extant","expurgate","fallacious","fatuous","fetter","flagrant","foil","forbearance","fortuitous","fractious","garrulous","gourmand","grandiloquent","gratuitous","hapless","hegemony","heterogenous","iconoclast","idiosyncratic","impecunious","impetuous","impinge","impute","inane","inchoate","incontrovertible","incumbent","inexorable","inimical","injunction","inoculate","insidious","instigate","insurgent","interlocutor","intimation","inure","invective","intransigent","inveterate","irreverence","knell","laconic","largesse","legerdemain","libertarian","licentious","linchpin","litigant","maelstrom","maudlin","maverick","mawkish","maxim","mendacious","modicum","morass","mores","munificent","multifarious","nadir","negligent","neophyte","noisome","noxious","obdurate","obfuscate","obstreperous","officious","onerous","ostensible","ostracism","palliate","panacea","paradigm","pariah","partisan","paucity","pejorative","pellucid","penchant","penurious","pert","pernicious","pertinacious","phlegmatic","philanthropic","pithy","platitude","plaudit","plenitude","plethora","portent","potentate","preclude","predilection","preponderance","presage","probity","proclivity","profligate","promulgate","proscribe","protean","prurient","puerile","pugnacious","pulchritude","punctilious","quaint","quixotic","quandary","recalcitrant","redoubtable","relegate","remiss","reprieve","reprobate","rescind","requisition","rife","sanctimonious","sanguine","scurrilous","semaphore","serendipity","sobriety","solicitous","solipsism","spurious","staid","stolid","subjugate","surfeit","surreptitious","swarthy","tangential","tome","toady","torpid","travesty","trenchant","trite","truculent","turpitude","ubiquitous","umbrage","upbraid","utilitarian","veracity","vestige","vicissitude","vilify","virtuoso","vitriolic","vituperate","vociferous","wanton","winsome","yoke","zephyr","wily","tirade"};
    String []meaning ={"of the most contemptible kind","a state or condition markedly different from the norm","formally reject or disavow a formerly held belief","the denial and rejection of a doctrine or belief","revoke formally","run away, often taking something or somebody along","difficult to penetrate","yield to another's wish or opinion","approach and speak to someone aggressively or insistently","an increase by natural growth or addition","shrewdness shown by keen insight","impervious to pleas, persuasion, requests, reason","scold or reprimand; take to task","describe roughly or give the main points or summary of","in an opposing direction","a person who pleads for a person, cause, or idea","having an abundant supply of money or possessions of value","embellish; increase the scope, power, or importance of","liveliness and eagerness","a name that has been assumed temporarily","uncertain or unable to decide about what course to follow","disposed or willing to comply","having no definite form or distinct shape","chronologically misplaced","a formal ecclesiastical curse accompanied by excommunication","attach to","of or relating to the period before the biblical flood","thoroughly clean and free of disease-causing organisms","showing little or no emotion or animation","exact opposite","being of questionable authenticity","official approval","based on or subject to individual discretion or preference","of or relating to or formed by trees","requiring secret or mysterious knowledge","of an original type after which other things are patterned","seize and take control without authority","someone who practices self denial as a spiritual discipline","a disparaging remark","marked by care and persistent effort","a decrease in size of an organ caused by disease or disuse","something causing misery or death","self-consciously timid","influence by slyness","sorrowful through loss or deprivation","flattery intended to persuade","cheat somebody out of what is due, especially money","ostentatiously lofty in style","influence or urge by gentle urging, caressing, or flattering","emotionally hardened","a false accusation of an offense","the quality of affording easy familiarity and sociability","the quality of being honest and straightforward","surrender under agreed conditions","engage in boisterous, drunken merrymaking","any of various freshwater fish of the family Cyprinidae","meet to select a candidate or promote a policy","play boisterously","an indirect way of expressing something","draw a geometric figure around another figure","surround so as to force to give up","utter or proclaim insistently and noisily","separate or cut with a tool, such as a sharp instrument","a person who makes or repairs shoes","powerfully persuasive","having or showing knowledge or understanding or realization","corresponding in size or degree or extent","something added to embellish or make perfect","a feeling of deep regret, usually for some misdeed","following or accompanying as a consequence","a passage through which water or electric wires can pass","a very intense and uncontrolled fire","the quality of agreeing; being suitable and appropriate","form intrigues (for) in an underhand manner","give over to another for care or safekeeping","one of the individual parts making up a composite entity","make sense of; assign a meaning to","an injury in which the skin is not broken","feeling or expressing pain or sorrow for sins or offenses","showing an inclination to disagree","go against, as of rules and laws","occupied with or fond of the pleasures of good company","the property of excessive fatness","wish, long, or crave for","extreme greed for material wealth","an insufficient quantity or number","a sudden and violent collapse","a wild gathering involving excessive drinking","expose while ridiculing","no longer in force or use; inactive","a leader who seeks support by appealing to popular passions","charge falsely or with malicious intent","a compound obtained from another compound","a cruel and oppressive dictator","so thin as to transmit light","instructive, especially excessively","a song or hymn of mourning as a memorial to a dead person","discontented as toward authority","cause to lose one's composure","fundamentally different or distinct in quality or kind","to cause to separate and go in different directions","the state of being held in low esteem","dissenting with the majority opinion","pertaining to a code of beliefs accepted as authoritative","showing a brooding ill humor","the act of deceiving or acting in bad faith","compulsory force or threat","selecting what seems best of various styles or ideas","a formal or authoritative proclamation","joyously unrestrained","conspicuously and outrageously bad or reprehensible","a mournful poem; a lament for the dead","call forth, as an emotion, feeling, or response","the fraudulent appropriation of funds or property","make corrections to","a substance with a soothing effect when applied to the skin","derived from experiment and observation rather than theory","strive to equal or match, especially by imitating","weaken mentally or morally","grant freedom to, as from slavery or servitude","call forth","anything short-lived, as an insect that lives only for a day","written in the form of letters or correspondence","steadiness of mind under stress","open to two or more interpretations","choose and follow a theory, idea, policy, etc.","tending to vanish like vapor","give expression to","make worse","spur on or encourage especially by cheers and shouts","unequivocally detestable","demanding immediate attention","appropriate to a purpose","make amends for","remove by erasing or crossing out or as if by drawing a line","not belonging to that in which it is contained","praise, glorify, or honor","still in existence; not extinct or destroyed or lost","edit by omitting or modifying parts considered indelicate","containing or based on incorrect reasoning","devoid of intelligence","a shackle for the ankles or feet","conspicuously and outrageously bad or reprehensible","hinder or prevent, as an effort, plan, or desire","good-natured tolerance of delay or incompetence","occurring by happy chance","easily irritated or annoyed","full of trivial conversation","a person who is devoted to eating and drinking to excess","lofty in style","unnecessary and unwarranted","unfortunate and deserving pity","the dominance or leadership of one social group over others","consisting of elements that are not of the same kind","someone who attacks cherished ideas or institutions","peculiar to the individual","not having enough money to pay for necessities","characterized by undue haste and lack of thought","infringe upon","attribute or credit to","devoid of intelligence","only partly in existence; imperfectly formed","impossible to deny or disprove","necessary as a duty or responsibility; morally binding","not to be placated or appeased or moved by entreaty","not friendly","a judicial remedy to prohibit a party from doing something","inject or treat with the germ of a disease to render immune","working or spreading in a hidden and usually injurious way","provoke or stir up","in opposition to a civil authority or government","a person who takes part in a conversation","a slight suggestion or vague understanding","cause to accept or become hardened to","abusive language used to express blame or censure","impervious to pleas, persuasion, requests, or reason","habitual","a mental attitude showing lack of due respect","the sound of a bell rung slowly to announce a death","brief and to the point","liberality in bestowing gifts","an illusory feat","an advocate of freedom of thought and speech","lacking moral discipline","a central cohesive source of support and stability","(law) a party to a lawsuit; someone involved in litigation","a powerful circular current of water","effusively or insincerely emotional","someone who exhibits independence in thought and action","effusively or insincerely emotional","a saying that is widely accepted on its own merits","given to lying","a small or moderate or token amount","a soft wet area of low-lying land that sinks underfoot","the conventions embodying the fundamental values of a group","very generous","having many aspects","the lowest point of anything","characterized by undue lack of attention or concern","any new participant in some activity","offensively malodorous","injurious to physical or mental health","stubbornly persistent in wrongdoing","make obscure or unclear","noisily and stubbornly defiant","intrusive in a meddling or offensive manner","not easily borne; wearing","appearing as such but not necessarily so","the act of excluding someone from society by general consent","lessen or to try to lessen the seriousness or extent of","hypothetical remedy for all ills or diseases","a standard or typical example","a person who is rejected from society or home","a fervent and even militant proponent of something","an insufficient quantity or number","expressing disapproval","transparently clear; easily understandable","a strong liking","excessively unwilling to spend","characterized by a lightly saucy or impudent quality","exceedingly harmful","stubbornly unyielding","showing little emotion","of or relating to charitable giving","concise and full of meaning","a trite or obvious remark","enthusiastic approval","a full supply","extreme excess","a sign of something about to happen","a ruler who is unconstrained by law","make impossible, especially beforehand","a predisposition in favor of something","exceeding in heaviness; having greater weight","a foreboding about what is about to happen","complete and confirmed integrity","a natural inclination","unrestrained by convention or morality","state or announce","command against","taking on different forms","characterized by lust","displaying or suggesting a lack of maturity","ready and able to resort to force or violence","physical beauty, especially of a woman","marked by precise accordance with details","attractively old-fashioned","not sensible about practical matters","state of uncertainty in a choice between unfavorable options","stubbornly resistant to authority or control","inspiring fear","assign to a lower position","failing in what duty requires","postpone the punishment of a convicted criminal","a person without moral scruples","cancel officially","an authoritative request or demand","excessively abundant","excessively or hypocritically pious","confidently optimistic and cheerful","expressing offensive reproach","an apparatus for visual signaling","good luck in making unexpected and fortunate discoveries","the state of being sober and not intoxicated by alcohol","full of anxiety and concern","the philosophical theory that the self is all that exists","plausible but false","characterized by dignity and propriety","having or revealing little emotion or sensibility","make subservient; force to submit or subdue","indulge (one's appetite) to satiety","marked by quiet and caution and secrecy","naturally having skin of a dark color","of superficial relevance if any","a large and scholarly book","a person who tries to please someone to gain an advantage","in a condition of biological rest or suspended animation","a composition that imitates or misrepresents a style","having keenness and forcefulness and penetration in thought","repeated too often; overfamiliar through overuse","defiantly aggressive","a corrupt or depraved or degenerate act or practice","being present everywhere at once","a feeling of anger caused by being offended","express criticism towards","having a useful function","unwillingness to tell lies","an indication that something has been present","a variation in circumstances or fortune","spread negative information about","someone who is dazzlingly skilled in any field","harsh, bitter, or malicious in tone","spread negative information about","conspicuously and offensively loud","a lewd or lascivious person","charming in a childlike or naive way","join with stable gear, as two draft animals","a slight wind","marked by skill in deception","a speech of violent denunciation"};
    int wordsLength = words.length;
    Random rand = new Random();

    int wordFlag,timerFlag;

    int randIndex;

    MyCount counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        PreferenceManager.setDefaultValues(this, R.xml.pref_headers, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final boolean key_vibs = sharedPreferences.getBoolean(getResources().getString(R.string.key_key_vibes), true);

        et = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.bA);
        b2 = (Button) findViewById(R.id.bB);
        b3 = (Button) findViewById(R.id.bC);
        b4 = (Button) findViewById(R.id.bD);
        b5 = (Button) findViewById(R.id.bE);
        b6 = (Button) findViewById(R.id.bF);
        b7 = (Button) findViewById(R.id.bG);
        b8 = (Button) findViewById(R.id.bH);
        b9 = (Button) findViewById(R.id.bI);
        b10 = (Button) findViewById(R.id.bJ);
        b11 = (Button) findViewById(R.id.bK);
        b12 = (Button) findViewById(R.id.bL);
        b13 = (Button) findViewById(R.id.bM);
        b14 = (Button) findViewById(R.id.bN);
        b15 = (Button) findViewById(R.id.bO);
        b16 = (Button) findViewById(R.id.bP);
        b17 = (Button) findViewById(R.id.bQ);
        b18 = (Button) findViewById(R.id.bR);
        b19 = (Button) findViewById(R.id.bS);
        b20 = (Button) findViewById(R.id.bT);
        b21 = (Button) findViewById(R.id.bU);
        b22 = (Button) findViewById(R.id.bV);
        b23 = (Button) findViewById(R.id.bW);
        b24 = (Button) findViewById(R.id.bX);
        b25 = (Button) findViewById(R.id.bY);
        b26 = (Button) findViewById(R.id.bZ);
        bs = (Button) findViewById(R.id.backspace);

        et.setInputType( InputType.TYPE_NULL );

        changeText();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            et.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            et.setTextIsSelectable(true);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "a"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "b"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "c"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "d"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "e"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "f"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "g"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "h"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "i"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "j"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "k"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "l"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "m"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "n"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "o"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "p"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "q"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "r"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "s"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "t"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "u"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "v"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "w"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "x"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "y"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().insert(et.getText().length(), "z"));
                if (key_vibs)
                    vibe.vibrate(60);
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key_vibs)
                    vibe.vibrate(60);
                if(et.getText().toString().length() > 0) {
                    et.setText(et.getText().delete(et.getText().length() - 1, et.getText().length()));
                }
            }
        });

//        play =(Button)findViewById(R.id.play);
        input = (TextView)findViewById(R.id.input);
        output = (TextView)findViewById(R.id.output);
        timer = (TextView)findViewById(R.id.timer);

        input.setTranslationY(-1000f);
        output.setTranslationY(2000f);
        wordFlag = 0;
        timerFlag = 0;

//        ************************************************
//                      REMOVE PLAY BUTTON
//        ************************************************
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                if(timerFlag == 0){
                    counter = new MyCount(30200,1000); // 200ms is added because first second goes fast
                    counter.start();
                    randIndex = rand.nextInt(wordsLength);
                    input.setText(words[randIndex]);
                    output.setText(meaning[randIndex]);
                    input.animate().translationYBy(1000f).setDuration(500);
                    output.animate().translationYBy(-2000f).setDuration(500);
                    randIndex = rand.nextInt(wordsLength);
                    timerFlag=1;
                    wordFlag=1;
                }
//            }
//        });

    }

    public void changeText() {
        int randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b1.setText("");
        } else b1.setText("a");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b2.setText("");
        } else b2.setText("b");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b3.setText("");
        } else b3.setText("c");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b4.setText("");
        } else b4.setText("d");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b5.setText("");
        } else b5.setText("e");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b6.setText("");
        } else b6.setText("f");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b7.setText("");
        } else b7.setText("g");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b8.setText("");
        } else b8.setText("h");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b9.setText("");
        } else b9.setText("i");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b10.setText("");
        } else b10.setText("j");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b11.setText("");
        } else b11.setText("k");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b12.setText("");
        } else b12.setText("l");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b13.setText("");
        } else b13.setText("m");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b14.setText("");
        } else b14.setText("n");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b15.setText("");
        } else b15.setText("o");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b16.setText("");
        } else b16.setText("p");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b17.setText("");
        } else b17.setText("q");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b18.setText("");
        } else b18.setText("r");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b19.setText("");
        } else b19.setText("s");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b20.setText("");
        } else b20.setText("t");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b21.setText("");
        } else b21.setText("u");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b22.setText("");
        } else b22.setText("v");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b23.setText("");
        } else b23.setText("w");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b24.setText("");
        } else b24.setText("x");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b25.setText("");
        } else b25.setText("y");
        randIndex = rand.nextInt(3);
        if(randIndex == 0||randIndex == 1) {
            b26.setText("");
        } else b26.setText("z");
    }

    public void checkText(View view) {
        input = (TextView)findViewById(R.id.input);
        yourscoretext = (TextView)findViewById(R.id.yourscoretext);

        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.correctsound2);

        PreferenceManager.setDefaultValues(this, R.xml.pref_headers, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean corr_sound = sharedPreferences.getBoolean(getResources().getString(R.string.correct_sound), true);
        boolean wrong_vibs = sharedPreferences.getBoolean(getResources().getString(R.string.key_vibration_name), true);


        if(et.getText().toString().equalsIgnoreCase(input.getText().toString())) {
            if(wordFlag==1){
                input.setTranslationY(-1000f);
                output.setTranslationY(2000f);
            }
            changeText();

            if (corr_sound == true)
               mp.start();

            seenWords.add(input.getText().toString());
            seenMeanings.add(output.getText().toString());
            yourScore++;
            et.setText("");
            int randIndex = rand.nextInt(wordsLength);
            input.setText(words[randIndex]);
            output.setText(meaning[randIndex]);

            Animation animZoomIn, animZoomOut;
            animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
            yourscoretext.startAnimation(animZoomOut);
            yourscoretext.setText(yourScore.toString());
            yourscoretext.startAnimation(animZoomIn);


            input.animate().translationYBy(1000f).setDuration(500);
            output.animate().translationYBy(-2000f).setDuration(500);
            randIndex = rand.nextInt(wordsLength);
            timerFlag=1;
            wordFlag=1;
//            Log.i("Check Marker", "Check Marker Yes");
        } else {
            Toast.makeText(getApplicationContext(), "Check your spelling again!", Toast.LENGTH_SHORT).show();
            if (wrong_vibs == true)
               vibe.vibrate(100);
//            Log.i("Check Marker", "Check Marker No");
        }
    }

    public void hideKeyb(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            et.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            et.setTextIsSelectable(true);
        }
//        View newview = this.getCurrentFocus();
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(newview.getWindowToken(), 0);
    }

    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
//            tv.setText("Game ended!");
//            play.setVisibility(View.INVISIBLE);
            timer.setText("Left: 0s");
//            input.setVisibility(View.INVISIBLE);
            timerFlag = 0;
//            output.setVisibility(View.INVISIBLE);
            input.setTranslationY(-1000f);
            output.setTranslationY(2000f);
            wordFlag = 0;
//            Toast.makeText(getApplicationContext(),"Game ended",Toast.LENGTH_LONG).show();

            Intent z = new Intent(getApplicationContext(), GameOver.class);
            yourscoretext = (TextView) findViewById(R.id.yourscoretext);

            //for your score
            SharedPreferences sp2 = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
            sp2.edit().putInt("myScore", yourScore).apply();

            //for high score
            SharedPreferences sp = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
            int hs = sp.getInt("MyHighScore", 0);
            if (Integer.parseInt(yourscoretext.getText().toString()) > hs) {
                hs = Integer.parseInt(yourscoretext.getText().toString());
            }
//            Log.i("HS", String.valueOf(hs));
            sp.edit().putInt("MyHighScore", hs).apply();
//            sp.edit().apply();

            SharedPreferences sp3 = getSharedPreferences("com.keval.crazyqwerty", Context.MODE_PRIVATE);
            Set<String> wordset = new HashSet<String>(seenWords);
            Set<String> meaningset = new HashSet<String>(seenMeanings);
            sp3.edit().putStringSet("WordsLister", wordset).apply();
            sp3.edit().putStringSet("MeaningLister", meaningset).apply();

            startActivity(z);

        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText("Left: " + millisUntilFinished/1000 + "s");

        }

    }

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed

        counter.cancel();
        Intent z = new Intent(getApplicationContext(), NewGameActivity.class);
        startActivity(z);

        return;
    }
//
//    public void backButtonHandler() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
//                MainActivity.this);
//
////        counter.onPause1();
//
//        // Setting Dialog Title
//        alertDialog.setTitle("Leave Game?");
//        // Setting Dialog Message
//        alertDialog.setMessage("Are you sure you want to leave the application?");
//        // Setting Icon to Dialog
////        alertDialog.setIcon(R.drawable.dialog_icon);
//        // Setting Positive "Yes" Button
//        alertDialog.setPositiveButton("YES",
//        new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
////                MyCount.onFinish();
//            }
//        });
//        // Setting Negative "NO" Button
//        alertDialog.setNegativeButton("NO",
//        new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                // Write your code here to invoke NO event
//                dialog.cancel();
//            }
//        });
//        // Showing Alert Message
//        alertDialog.show();
//    }
//
//    protected void onResume() {
//        super.onResume();
//        //handler.removeCallbacks(updateTimeTask);
//        //handler.postDelayed(updateTimeTask, 1000);
//    }//onResume
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //do stuff
//    }//onPause

}
