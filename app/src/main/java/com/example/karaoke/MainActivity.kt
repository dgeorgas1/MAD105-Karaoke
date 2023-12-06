package com.example.karaoke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val songs = ArrayList<Model>()
    private lateinit var customAdapter: CustomAdapter

    private val ADD_SONG_REQUEST_CODE = 1
    private val DELETE_SONG_REQUEST_CODE = 2
    private val SELECT_SONG_REQUEST_CODE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songEntry = findViewById<EditText>(R.id.editMainSearchEntry)
        val searchButton = findViewById<Button>(R.id.buttonMainSearch)
        val listSongs = findViewById<ListView>(R.id.listSongs)
        val addSongButton = findViewById<Button>(R.id.buttonMainAdd)
        val deleteSongButton = findViewById<Button>(R.id.buttonMainDelete)

        customAdapter = CustomAdapter(this, R.layout.custom_line_item, songs)
        listSongs.adapter = customAdapter

        songs.add(Model("Hotel California", "Eagles", "Rock", "6:31", "On a dark desert highway\n" +
                "Cool wind in my hair\n" +
                "Warm smell of colitas\n" +
                "Rising up through the air\n" +
                "Up ahead in the distance\n" +
                "I saw a shimmering light\n" +
                "My head grew heavy and my sight grew dim\n" +
                "I had to stop for the night\n" +
                "There she stood in the doorway\n" +
                "I heard the mission bell\n" +
                "And I was thinkin' to myself\n" +
                "\"This could be heaven or this could be hell\"\n" +
                "Then she lit up a candle\n" +
                "And she showed me the way\n" +
                "There were voices down the corridor\n" +
                "I thought I heard them say\n" +
                "\"Welcome to the Hotel California\n" +
                "Such a lovely place (such a lovely place)\n" +
                "Such a lovely face\n" +
                "Plenty of room at the Hotel California\n" +
                "Any time of year (any time of year)\n" +
                "You can find it here\"\n" +
                "Her mind is Tiffany-twisted\n" +
                "She got the Mercedes-Benz, uh\n" +
                "She got a lot of pretty, pretty boys\n" +
                "That she calls friends\n" +
                "How they dance in the courtyard\n" +
                "Sweet summer sweat\n" +
                "Some dance to remember\n" +
                "Some dance to forget\n" +
                "So I called up the Captain\n" +
                "\"Please bring me my wine\"\n" +
                "He said, \"We haven't had that spirit here\n" +
                "Since 1969\"\n" +
                "And still, those voices are calling\n" +
                "From far away\n" +
                "Wake you up in the middle of the night\n" +
                "Just to hear them say\n" +
                "\"Welcome to the Hotel California\n" +
                "Such a lovely place (such a lovely place)\n" +
                "Such a lovely face\n" +
                "They're livin' it up at the Hotel California\n" +
                "What a nice surprise (what a nice surprise)\n" +
                "Bring your alibis\"\n" +
                "Mirrors on the ceiling\n" +
                "The pink champagne on ice\n" +
                "And she said, \"We are all just prisoners here\n" +
                "Of our own device\"\n" +
                "And in the master's chambers\n" +
                "They gathered for the feast\n" +
                "They stab it with their steely knives\n" +
                "But they just can't kill the beast\n" +
                "Last thing I remember\n" +
                "I was running for the door\n" +
                "I had to find the passage back\n" +
                "To the place I was before\n" +
                "\"Relax, \" said the night man\n" +
                "\"We are programmed to receive\n" +
                "You can check out any time you like\n" +
                "But you can never leave!\""))
        songs.add(Model("Livin' on a Prayer", "Bon Jovi", "Rock", "4:08", "Once upon a time, not so long ago\n" +
                "Tommy used to work on the docks, union's been on strike\n" +
                "He's down on his luck, it's tough, so tough\n" +
                "Gina works the diner all day, working for her man\n" +
                "She brings home her pay, for love, mmm, for love\n" +
                "She says, \"We've gotta hold on to what we've got\n" +
                "It doesn't make a difference if we make it or not\n" +
                "We've got each other and that's a lot for love\n" +
                "We'll give it a shot\"\n" +
                "Whoa, we're half way there\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Take my hand, we'll make it, I swear\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Tommy's got his six string in hock, now he's holding in\n" +
                "When he used to make it talk so tough, ooh, it's tough\n" +
                "Gina dreams of running away\n" +
                "When she cries in the night, Tommy whispers\n" +
                "\"Baby, it's okay, someday\"\n" +
                "We've gotta hold on to what we've got\n" +
                "It doesn't make a difference if we make it or not\n" +
                "We've got each other and that's a lot for love\n" +
                "We'll give it a shot\n" +
                "Whoa, we're half way there\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Take my hand, we'll make it I swear\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Livin' on a prayer\n" +
                "Oh, we've gotta hold on, ready or not\n" +
                "You live for the fight when that's all that you've got\n" +
                "Whoa, we're half way there\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Take my hand and we'll make it, I swear\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Whoa, we're half way there\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Take my hand and we'll make it, I swear\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Whoa, we're half way there\n" +
                "Whoa oh, livin' on a prayer\n" +
                "Take my hand and we'll make it, I swear\n" +
                "Whoa oh"))
        songs.add(Model("Don't Stop Believin", "Journey", "Rock", "4:10", "Just a small town girl\n" +
                "Livin' in a lonely world\n" +
                "She took the midnight train going anywhere\n" +
                "Just a city boy\n" +
                "Born and raised in South Detroit\n" +
                "He took the midnight train going anywhere\n" +
                "A singer in a smokey room\n" +
                "A smell of wine and cheap perfume\n" +
                "For a smile they can share the night\n" +
                "It goes on and on and on and on\n" +
                "Strangers waitin'\n" +
                "Up and down the boulevard\n" +
                "Their shadows searchin' in the night\n" +
                "Streetlights, people\n" +
                "Livin' just to find emotion\n" +
                "Hidin', somewhere in the night\n" +
                "Workin' hard to get my fill\n" +
                "Everybody wants a thrill\n" +
                "Payin' anything to roll the dice\n" +
                "Just one more time\n" +
                "Some'll win, some will lose\n" +
                "Some are born to sing the blues\n" +
                "Whoa, the movie never ends\n" +
                "It goes on and on and on and on\n" +
                "Strangers waitin'\n" +
                "Up and down the boulevard\n" +
                "Their shadows searchin' in the night\n" +
                "Streetlights, people\n" +
                "Livin' just to find emotion\n" +
                "Hidin', somewhere in the night\n" +
                "Don't stop believin'\n" +
                "Hold on to that feelin'\n" +
                "Streetlights, people\n" +
                "Don't stop believin'\n" +
                "Hold on\n" +
                "Streetlights, people\n" +
                "Don't stop believin'\n" +
                "Hold on to that feelin'\n" +
                "Streetlights, people"))
        songs.add(Model("Paint It Black", "The Rolling Stones", "Rock", "3:14", "I see a red door\n" +
                "And I want it painted black\n" +
                "No colors anymore\n" +
                "I want them to turn black\n" +
                "I see the girls walk by\n" +
                "Dressed in their summer clothes\n" +
                "I have to turn my head\n" +
                "Until my darkness goes\n" +
                "I see a line of cars\n" +
                "And they're all painted black\n" +
                "With flowers and my love\n" +
                "Both never to come back\n" +
                "I've seen people turn their heads\n" +
                "And quickly look away\n" +
                "Like a newborn baby\n" +
                "It just happens everyday\n" +
                "I look inside myself\n" +
                "And see my heart is black\n" +
                "I see my red door\n" +
                "I must have it painted black\n" +
                "Maybe then, I'll fade away\n" +
                "And not have to face the facts\n" +
                "It's not easy facing up\n" +
                "When your whole world is black\n" +
                "No more will my green sea\n" +
                "Go turn a deeper blue\n" +
                "I could not foresee this thing\n" +
                "Happening to you\n" +
                "If I look hard enough\n" +
                "Into the setting sun\n" +
                "My love will laugh with me\n" +
                "Before the morning comes\n" +
                "I see a red door\n" +
                "And I want it painted black\n" +
                "No colors anymore\n" +
                "I want them to turn black\n" +
                "I see the girls walk by\n" +
                "Dressed in their summer clothes\n" +
                "I have to turn my head\n" +
                "Until my darkness goes\n" +
                "I wanna see it painted\n" +
                "Painted black\n" +
                "Black as night\n" +
                "Black as coal\n" +
                "I wanna see the sun\n" +
                "Blotted out from the sky\n" +
                "I wanna see it painted, painted, painted\n" +
                "Painted black, yeah"))
        songs.add(Model("Free Bird", "Lynyrd Skynyrd", "Southern Rock", "9:05", "If I leave here tomorrow\n" +
                "Would you still remember me?\n" +
                "For I must be traveling on now\n" +
                "'Cause there's too many places I've got to see\n" +
                "But if I stay here with you, girl\n" +
                "Things just couldn't be the same\n" +
                "'Cause I'm as free as a bird now\n" +
                "And this bird you cannot change\n" +
                "Oh, oh, oh, oh\n" +
                "And the bird you cannot change\n" +
                "And this bird, you cannot change\n" +
                "Lord knows, I can't change\n" +
                "Bye-bye baby, it's been sweet love, yeah, yeah\n" +
                "Though this feelin' I can't change\n" +
                "But please don't take it so badly\n" +
                "'Cause Lord knows, I'm to blame\n" +
                "But if I stay here with you, girl\n" +
                "Things just couldn't be the same\n" +
                "'Cause I'm as free as a bird now\n" +
                "And this bird you cannot change\n" +
                "Oh, oh, oh, oh\n" +
                "And the bird you cannot change\n" +
                "And this bird, you cannot change\n" +
                "Lord knows, I can't change\n" +
                "Lord help me, I can't change\n" +
                "Lord, I can't change\n" +
                "Won't you fly high, free bird, yeah"))
        songs.add(Model("Roxanne", "The Police", "New Wave", "3:27", "Roxanne\n" +
                "You don't have to put on the red light\n" +
                "Those days are over\n" +
                "You don't have to sell your body to the night\n" +
                "Roxanne\n" +
                "You don't have to wear that dress tonight\n" +
                "Walk the streets for money\n" +
                "You don't care if it's wrong or if it's right\n" +
                "Roxanne\n" +
                "You don't have to put on the red light\n" +
                "Roxanne\n" +
                "You don't have to put on the red light\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Ro\n" +
                "I loved you since I knew you\n" +
                "I wouldn't talk down to you\n" +
                "I have to tell you just how I feel\n" +
                "I won't share you with another boy\n" +
                "I know my mind is made up\n" +
                "So put away your make up\n" +
                "Told you once I won't tell you again\n" +
                "It's a bad way\n" +
                "Roxanne\n" +
                "You don't have to put on the red light\n" +
                "Roxanne\n" +
                "You don't have to put on the red light\n" +
                "Roxanne (You don't have to put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (You don't have to put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)\n" +
                "Roxanne (Put on the red light)"))
        songs.add(Model("More Than a Feeling", "Boston", "Rock", "4:44", "I looked out this morning and the sun was gone\n" +
                "Turned on some music to start my day\n" +
                "I lost myself in a familiar song\n" +
                "I closed my eyes and I slipped away\n" +
                "It's more than a feeling\n" +
                "(More than a feeling)\n" +
                "When I hear that old song they used to play\n" +
                "(More than a feeling)\n" +
                "I begin dreaming\n" +
                "(More than a feeling)\n" +
                "'Til I see Marianne walk away\n" +
                "I see my Marianne walkin' away\n" +
                "So many people have come and gone\n" +
                "Their faces fade as the years go by\n" +
                "Yet I still recall as I wander on\n" +
                "As clear as the sun in the summer sky\n" +
                "It's more than a feeling\n" +
                "(More than a feeling)\n" +
                "When I hear that old song they used to play\n" +
                "(More than a feeling)\n" +
                "I begin dreaming\n" +
                "(More than a feeling)\n" +
                "'Til I see Marianne walk away\n" +
                "I see my Marianne walkin' away\n" +
                "When I'm tired and thinking cold\n" +
                "I hide in my music, forget the day\n" +
                "And dream of a girl I used to know\n" +
                "I closed my eyes and she slipped away\n" +
                "She slipped away\n" +
                "It's more than a feeling\n" +
                "(More than a feeling)\n" +
                "When I hear that old song they used to play\n" +
                "(More than a feeling)\n" +
                "I begin dreaming\n" +
                "(More than a feeling)\n" +
                "'Til I see Marianne walk away"))
        songs.add(Model("Sweet Emotion", "Aerosmith", "Rock", "4:29", "Sweet emotion\n" +
                "Sweet emotion\n" +
                "You talk about things that nobody cares\n" +
                "Wearing out things that nobody wears\n" +
                "You're calling my name but I gotta make clear\n" +
                "I can't say, baby, where I'll be in a year\n" +
                "Some sweat hog mama with a face like a gent\n" +
                "Said my get up and go, must've got up and went\n" +
                "Well I got good news, she's a real good liar\n" +
                "'Cause the backstage boogie sets your pants on fire\n" +
                "Sweet emotion\n" +
                "Sweet emotion\n" +
                "I pulled into town in a police car\n" +
                "Your daddy said I took it just a little too far\n" +
                "You're telling her things but your girlfriend lied\n" +
                "You can't catch me 'cause the rabbit done died\n" +
                "Yes it did\n" +
                "Stand in the front just a shakin' your ass\n" +
                "I'll take you backstage, you can drink from my glass\n" +
                "I'll talk about something you can sure understand\n" +
                "'Cause a month on the road and I'll be eating from your hand"))
        songs.add(Model("The Sound of Silence", "Simon & Garfunkel", "Folk Rock", "3:51", "Hello darkness, my old friend\n" +
                "I've come to talk with you again\n" +
                "Because a vision softly creeping\n" +
                "Left its seeds while I was sleeping\n" +
                "And the vision that was planted in my brain\n" +
                "Still remains\n" +
                "Within the sound of silence\n" +
                "In restless dreams I walked alone\n" +
                "Narrow streets of cobblestone\n" +
                "'Neath the halo of a street lamp\n" +
                "I turned my collar to the cold and damp\n" +
                "When my eyes were stabbed by the flash of a neon light\n" +
                "That split the night\n" +
                "And touched the sound of silence\n" +
                "And in the naked light I saw\n" +
                "Ten thousand people, maybe more\n" +
                "People talking without speaking\n" +
                "People hearing without listening\n" +
                "People writing songs that voices never share\n" +
                "No one dared\n" +
                "Disturb the sound of silence\n" +
                "\"Fools\" said I, \"You do not know\n" +
                "Silence like a cancer grows\n" +
                "Hear my words that I might teach you\n" +
                "Take my arms that I might reach you\"\n" +
                "But my words like silent raindrops fell\n" +
                "And echoed in the wells of silence\n" +
                "And the people bowed and prayed\n" +
                "To the neon god they made\n" +
                "And the sign flashed out its warning\n" +
                "In the words that it was forming\n" +
                "And the sign said, \"The words of the prophets\n" +
                "Are written on the subway walls\n" +
                "And tenement halls\n" +
                "And whispered in the sounds of silence\""))
        songs.add(Model("Crazy Train", "Ozzy Osbourne", "Heavy Metal", "5:40", "All aboard Ha ha ha ha ha ha ha\n" +
                "Ay, ay, ay, ay, ay, ay, ay\n" +
                "Crazy, but that's how it goes\n" +
                "Millions of people living as foes\n" +
                "Maybe it's not too late\n" +
                "To learn how to love\n" +
                "And forget how to hate\n" +
                "Mental wounds not healing\n" +
                "Life's a bitter shame\n" +
                "I'm going off the rails on a crazy train\n" +
                "I'm going off the rails on a crazy train\n" +
                "Let's go\n" +
                "I've listened to preachers\n" +
                "I've listened to fools\n" +
                "I've watched all the dropouts\n" +
                "Who make their own rules\n" +
                "One person conditioned to rule and control\n" +
                "The media sells it, and you live the role\n" +
                "Mental wounds still screaming\n" +
                "Driving me insane\n" +
                "I'm going off the rails on a crazy train\n" +
                "I'm going off the rails on a crazy train\n" +
                "I know that things are going wrong for me\n" +
                "You gotta listen to my words, yeah\n" +
                "Heirs of a cold war\n" +
                "That's what we've become\n" +
                "Inheriting troubles, I'm mentally numb\n" +
                "Crazy, I just cannot bear\n" +
                "I'm living with something that just isn't fair\n" +
                "Mental wounds not healing\n" +
                "Who and what's to blame?\n" +
                "I'm going off the rails on a crazy train\n" +
                "I'm going off the rails on a crazy train\n" +
                "Ha ha ha ha ha ha ha\n" +
                "The ledge, ha-ha, the edge"))
        songs.add(Model("Enter Sandman", "Metallica", "Heavy Metal", "5:31", "Say your prayers, little one\n" +
                "Don't forget, my son\n" +
                "To include everyone\n" +
                "Tuck you in, warm within\n" +
                "Keep you free from sin\n" +
                "'Til the sandman, he comes\n" +
                "Sleep with one eye open\n" +
                "Gripping your pillow tight\n" +
                "Exit light\n" +
                "Enter night\n" +
                "Take my hand\n" +
                "We're off to never-never land\n" +
                "Somethings wrong, shut the light\n" +
                "Heavy thoughts tonight\n" +
                "And they aren't of Snow White\n" +
                "Dreams of war, dreams of liars\n" +
                "Dreams of dragon's fire\n" +
                "And of things that will bite, yeah\n" +
                "Sleep with one eye open\n" +
                "Gripping your pillow tight\n" +
                "Exit light\n" +
                "Enter night\n" +
                "Take my hand\n" +
                "We're off to never-never land\n" +
                "Now I lay me down to sleep\n" +
                "Now I lay me down to sleep\n" +
                "I pray the Lord my soul to keep\n" +
                "I pray the Lord my soul to keep\n" +
                "If I die before I wake\n" +
                "If I die before I wake\n" +
                "I pray the Lord my soul to take\n" +
                "I pray the Lord my soul to take\n" +
                "Hush, little baby, don't say a word\n" +
                "And never mind that noise you heard\n" +
                "It's just the beasts under your bed\n" +
                "In your closet, in your head\n" +
                "Exit light\n" +
                "Enter night\n" +
                "Grain of sand\n" +
                "Exit light\n" +
                "Enter night\n" +
                "Take my hand\n" +
                "We're off to never-never land, yeah\n" +
                "Uh\n" +
                "Yeah, yeah\n" +
                "Yo, oh\n" +
                "We're off to never-never land\n" +
                "Take my hand\n" +
                "We're off to never-never land\n" +
                "Take my hand\n" +
                "We're off to never-never land"))
        songs.add(Model("We Will Rock You", "Queen", "Rock", "2:02", "Buddy, you're a boy, make a big noise\n" +
                "Playing in the street, gonna be a big man someday\n" +
                "You got mud on your face, you big disgrace\n" +
                "Kicking your can all over the place, singin'\n" +
                "We will, we will rock you\n" +
                "We will, we will rock you\n" +
                "Buddy, you're a young man, hard man\n" +
                "Shouting in the street, gonna take on the world someday\n" +
                "You got blood on your face, you big disgrace\n" +
                "Waving your banner all over the place\n" +
                "We will, we will rock you, sing it\n" +
                "We will, we will rock you\n" +
                "Buddy, you're an old man, poor man\n" +
                "Pleading with your eyes, gonna make you some peace someday\n" +
                "You got mud on your face, big disgrace\n" +
                "Somebody better put you back into your place\n" +
                "We will, we will rock you, sing it\n" +
                "We will, we will rock you, everybody\n" +
                "We will, we will rock you, hmm\n" +
                "We will, we will rock you\n" +
                "Alright"))
        songs.add(Model("American Woman", "The Guess Who", "Rock", "5:30", "American woman, I'm gonna mess your mind\n" +
                "American woman, you gonna mess your mind\n" +
                "American woman, I'm gonna mess your mind\n" +
                "American woman, I'm gonna mess your mind\n" +
                "Say A, say M, say E\n" +
                "Say R, say I, C\n" +
                "Say A, N\n" +
                "American woman, I'm gonna mess your mind\n" +
                "American woman, you gonna mess your mind\n" +
                "American woman, I'm gonna mess your mind\n" +
                "American woman, stay away from me\n" +
                "American woman, mama let me be\n" +
                "Don't come a hangin' around my door\n" +
                "I don't want to see your face no more\n" +
                "I got more important things to do\n" +
                "Than spend my time growin' old with you\n" +
                "Now woman, I said stay away\n" +
                "American woman, listen what I say\n" +
                "American woman, get away from me\n" +
                "American woman, mama let me be\n" +
                "Don't come a knockin' around my door\n" +
                "Don't want to see your shadow no more\n" +
                "Colored lights can hypnotize\n" +
                "Sparkle someone else's eyes\n" +
                "Now woman, I said get away\n" +
                "American woman, listen what I say-ay-ay-ay\n" +
                "American woman, said get away\n" +
                "American woman, listen what I say\n" +
                "Don't come a hangin' around my door\n" +
                "Don't want to see your face no more\n" +
                "I don't need your war machines\n" +
                "I don't need your ghetto scenes\n" +
                "Colored lights can hypnotize\n" +
                "Sparkle someone else's eyes\n" +
                "Now woman, get away from me\n" +
                "American woman, mama let me be\n" +
                "Go, gotta get away, gotta get away now go, go, go\n" +
                "I'm gonna leave you woman\n" +
                "Gonna leave you woman\n" +
                "Bye-bye bye-bye, bye-bye, bye-bye\n" +
                "You're no good for me\n" +
                "I'm no good for you\n" +
                "Gonna look you right in the eye\n" +
                "Tell you what I'm gonna do\n" +
                "You know I'm gonna leave\n" +
                "You know I'm gonna go\n" +
                "You know I'm gonna leave\n" +
                "You know I'm gonna go-o, woman\n" +
                "I'm gonna leave you woman\n" +
                "Goodbye American woman"))
        songs.add(Model("Heartbreaker", "Pat Benatar", "Rock", "3:35", "Your love is like a tidal wave, spinning over my head\n" +
                "Drownin' me in your promises, better left unsaid\n" +
                "You're the right kind of sinner to release my inner fantasy\n" +
                "The invincible winner and you know that you were born to be\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around with me\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around, no, no, no\n" +
                "Your love has set my soul on fire, burnin' out of control\n" +
                "You taught me the ways of desire now it's takin' its toll\n" +
                "You're the right kind of sinner, to release my inner fantasy\n" +
                "The invincible winner and you know that you were born to be\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around with me\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around, no, no, no\n" +
                "You're the right kind of sinner, to release my inner fantasy\n" +
                "The invincible winner and you know that you were born to be\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around with me\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around with me\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Don't you mess around with me\n" +
                "You're a heartbreaker\n" +
                "Dream maker, love taker\n" +
                "Heartbreaker"))
        songs.add(Model("Walk This Way", "Aerosmith", "Rock", "3:53", "Now there's a backseat, lover\n" +
                "That's always undercover\n" +
                "And I talk 'til my daddy say\n" +
                "Said, \"you ain't seen, nothin'\n" +
                "'Til you're down on the muffin\n" +
                "And there's sure to be a change in ways\"\n" +
                "Now there's a cheerleader\n" +
                "That's a real big pleaser\n" +
                "As far as I can reminisce\n" +
                "And the best thing of loving\n" +
                "Was her sister and her cousin\n" +
                "And it started with a little kiss, like this\n" +
                "See-saw swingin'\n" +
                "With the boys in school\n" +
                "And her feet was flyin' up in the air\n" +
                "Singin', \"Hey diddle diddle with a kitty in the middle\"\n" +
                "And they swingin' like it just don't care\n" +
                "So I took a big chance\n" +
                "At the high school dance\n" +
                "With a lady who was ready to play\n" +
                "It wasn't me she was foolin'\n" +
                "'Cause she knew what was she was doin'\n" +
                "When she told me how to walk this way\n" +
                "She told me to\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "She told me to\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Well, just gimme a kiss!\n" +
                "Ooh, a-like this!\n" +
                "School girl sleazy\n" +
                "With a classy kind of sassy\n" +
                "Little skirt hangin' way up her knee\n" +
                "There were three young ladies\n" +
                "In the school gym locker\n" +
                "And they find they were lookin' at D\n" +
                "I was high school loser\n" +
                "Never made it with a lady\n" +
                "'Til the boys told me somethin' I missed\n" +
                "That my next door neighbor\n" +
                "Had a daughter, had a favor\n" +
                "And I gave the girl a little kiss, like this\n" +
                "See-saw swingin'\n" +
                "With the boys in school\n" +
                "With your feet was flyin' up in the air\n" +
                "Singin', \"Hey diddle diddle with a kitty in the middle\"\n" +
                "I was swingin' like I didn't care\n" +
                "So I took a big chance\n" +
                "At the high school dance\n" +
                "With a missy who was ready to play\n" +
                "It wasn't me she was foolin'\n" +
                "When she knew what was she was doin'\n" +
                "When she told me how to walk this way\n" +
                "She told me to\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "She told me to\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Walk this way!\n" +
                "Talk this way!\n" +
                "Like this"))
        songs.add(Model("Carry on Wayward Son", "Kansas", "Rock", "5:07", "Carry on, my wayward son\n" +
                "There'll be peace when you are done\n" +
                "Lay your weary head to rest\n" +
                "Don't you cry no more\n" +
                "Once I rose above the noise and confusion\n" +
                "Just to get a glimpse beyond this illusion\n" +
                "I was soaring ever higher\n" +
                "But I flew too high\n" +
                "Though my eyes could see, I still was a blind man\n" +
                "Though my mind could think, I still was a mad man\n" +
                "I hear the voices when I'm dreaming\n" +
                "I can hear them say\n" +
                "Carry on, my wayward son\n" +
                "There'll be peace when you are done\n" +
                "Lay your weary head to rest\n" +
                "Don't you cry no more\n" +
                "Masquerading as a man with a reason\n" +
                "My charade is the event of the season\n" +
                "And if I claim to be a wise man, well\n" +
                "It surely means that I don't know\n" +
                "On a stormy sea of moving emotion\n" +
                "Tossed about, I'm like a ship on the ocean\n" +
                "I set a course for winds of fortune\n" +
                "But I hear the voices say\n" +
                "Carry on my wayward son\n" +
                "There'll be peace when you are done\n" +
                "Lay your weary head to rest\n" +
                "Don't you cry no more, no\n" +
                "Carry on, you will always remember\n" +
                "Carry on, nothing equals the splendor\n" +
                "Now your life's no longer empty\n" +
                "Surely heaven waits for you\n" +
                "Carry on, my wayward son\n" +
                "There'll be peace when you are done\n" +
                "Lay your weary head to rest\n" +
                "Don't you cry, don't you cry no more\n" +
                "No more"))
        songs.add(Model("I Love Rock 'n' Roll", "Joan Jett", "Rock", "2:57", "I saw him dancin' there by the record machine\n" +
                "I knew he must've been about 17\n" +
                "The beat was goin' strong\n" +
                "Playin' my favorite song\n" +
                "And I could tell it wouldn't be long\n" +
                "'Til he was with me, yeah, me\n" +
                "And I could tell it wouldn't be long\n" +
                "'Til he was with me, yeah, me, singin'\n" +
                "\"I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with me\"\n" +
                "Ow!\n" +
                "He smiled, so I got up and asked for his name\n" +
                "\"That don't matter\", he said, \"'Cause it's all the same\"\n" +
                "Said, \"Can I take you home where we can be alone?\"\n" +
                "And next, we were movin' on, he was with me, yeah, me\n" +
                "Next, we were movin' on, he was with me, yeah, me, singin'\n" +
                "\"I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with me\"\n" +
                "Ow!\n" +
                "Said, \"Can I take you home where we can be alone?\n" +
                "Next, we were movin' on, he was with me, yeah, me\n" +
                "And we'll be movin' on and singin' that same old song\n" +
                "Yeah, with me, singin'\n" +
                "\"I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with me\"\n" +
                "I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with-\n" +
                "I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with-\n" +
                "I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with-\n" +
                "I love rock 'n roll\n" +
                "So put another dime in the jukebox, baby\n" +
                "I love rock 'n roll\n" +
                "So come and take your time and dance with me"))
        songs.add(Model("Come Together", "The Beatles", "Rock", "4:19", "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Here come old flat-top, he come groovin' up slowly\n" +
                "He got ju-ju eyeball, he one holy roller\n" +
                "He got hair down to his knee\n" +
                "Got to be a joker, he just do what he please\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "He wear no shoeshine, he got toe-jam football\n" +
                "He got monkey finger, he shoot Coca-Cola\n" +
                "He say, \"I know you, you know me\"\n" +
                "One thing I can tell you is you got to be free\n" +
                "Come together\n" +
                "Right now\n" +
                "Over me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "He bag production, he got walrus gumboot\n" +
                "He got Ono sideboard, he one spinal cracker\n" +
                "He got feet down below his knee\n" +
                "Hold you in his armchair, you can feel his disease\n" +
                "Come together\n" +
                "Right now\n" +
                "Over me\n" +
                "Shoot me\n" +
                "Right!\n" +
                "Come\n" +
                "Come\n" +
                "Come\n" +
                "Come\n" +
                "Come\n" +
                "He roller-coaster, he got early warnin'\n" +
                "He got muddy water, he one mojo filter\n" +
                "He say, \"One and one and one is three\"\n" +
                "Got to be good-lookin' 'cause he's so hard to see\n" +
                "Come together\n" +
                "Right now\n" +
                "Over me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Shoot me\n" +
                "Ugh!\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together, yeah\n" +
                "Oh, come together, yeah\n" +
                "Come together, yeah\n" +
                "Come together"))

        songEntry.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= songEntry.right - songEntry.compoundDrawables[2].bounds.width()) {
                    customAdapter = CustomAdapter(this, R.layout.custom_line_item, songs)
                    listSongs.adapter = customAdapter
                    songEntry.setText("")
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }

        searchButton.setOnClickListener {
            val song = songEntry.text.toString()
            val songObject = songs.find { it.name == song }

            if (songObject != null) {
                val foundSong = ArrayList<Model>()
                foundSong.add(songObject)
                customAdapter = CustomAdapter(this, R.layout.custom_line_item, foundSong)
                listSongs.adapter = customAdapter

                Toast.makeText(this, "$song was found!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "$song was not found!", Toast.LENGTH_SHORT).show()
            }
        }
        
        listSongs.setOnItemClickListener { parent, view, position, id ->
            val song = songs[position].name
            val lyrics = songs[position].lyrics

            val intent = Intent(this, SelectSongActivity::class.java)
            intent.putExtra("song", song)
            intent.putExtra("lyrics", lyrics)
            startActivityForResult(intent, SELECT_SONG_REQUEST_CODE)
        }

        addSongButton.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java)
            startActivityForResult(intent, ADD_SONG_REQUEST_CODE)
        }

        deleteSongButton.setOnClickListener {
            val intent = Intent(this, DeleteSongActivity::class.java)
            startActivityForResult(intent, DELETE_SONG_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_SONG_REQUEST_CODE && resultCode == RESULT_OK) {
            val song = data?.getStringExtra("song")
            val artist = data?.getStringExtra("artist")
            val genre = data?.getStringExtra("genre")
            val duration = data?.getStringExtra("duration")
            val lyrics = data?.getStringExtra("lyrics")

            val songObject = Model("$song", "$artist", "$genre", "$duration", "$lyrics")
            if(songs.contains(songObject)) {
                Toast.makeText(this, "$song already is available!", Toast.LENGTH_SHORT).show()
            }
            else {
                songs.add(songObject)
                customAdapter.notifyDataSetChanged()

                Toast.makeText(this, "$song was successfully added!", Toast.LENGTH_SHORT).show()
            }
        }

        else if (requestCode == DELETE_SONG_REQUEST_CODE && resultCode == RESULT_OK) {
            val song = data?.getStringExtra("song")
            val songObject = songs.find { it.name == song }

            if (songObject != null) {
                songs.remove(songObject)
                customAdapter.notifyDataSetChanged()

                Toast.makeText(this, "$song was successfully deleted!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "$song is not available!", Toast.LENGTH_SHORT).show()
            }
        }

        else if (requestCode == SELECT_SONG_REQUEST_CODE && resultCode == RESULT_OK) {

        }
    }
}