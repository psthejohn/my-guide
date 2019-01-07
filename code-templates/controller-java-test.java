
@RunWith(SpringRunner.class)
@WebMvcTest(MuzixController.class)
public class MuzixControllerTest {

@Autowired
private MockMvc mockMvc;

@MockBean
private MuzixService muzixService;

private Artist artist;
private Image image;
private Track track;

private List<Track> trackList;

@Before
public void setUp(){
   trackList = new ArrayList<>();
   image = new Image(1,"http:url","large");
   artist = new Artist(101,"Jonhn","new url",image);
   track = new Track("Track1","Mynewtrack","new comments",123,"new track url",artist);

   trackList.add(track);

   image = new Image(2,"http:url","large");
   artist = new Artist(102,"Jonhnny","new url",image);
   track = new Track("Track2","Mynewtrack123","new comments updated",123,"new track url",artist);
   trackList.add(track);
}

@After
public void tearDown(){

   image = null;
   artist = null;
   track=null;
}

@Test
public void testSaveTrackSuccess() throws Exception {

when(muzixService.saveTrackToWishList(any())).thenReturn(track);
mockMvc.perform(post("/api/v1/muzixservice/track")
           .contentType(MediaType.APPLICATION_JSON).
                   content(jsonToString(track)))
           .andExpect(status().isCreated())
           .andDo(print());

}

@Test
public void testUpdateCommentSuccess() throws Exception {
   
when(muzixService.updateCommentForTrack((track.getComments()),(track.getTrackId()))).thenReturn(track);
   mockMvc.perform(patch("/api/v1/muzixservice/track/Track2?comments=updatedcomments")
           .contentType(MediaType.APPLICATION_JSON).
                   content(jsonToString(track)))
           .andExpect(status().isOk())
           .andDo(print());
}

@Test
public void testDeleteTrack() throws Exception {
   when(muzixService.deleteTrackFromWishList(track.getTrackId())).thenReturn(true);
   mockMvc.perform(delete("/api/v1/muzixservice/track/Track2")
           .contentType(MediaType.APPLICATION_JSON).
                   content(jsonToString(track)))
           .andExpect(status().isOk())
           .andDo(print());
}

@Test
public void getAllTrackFromWishList() throws Exception{

when(muzixService.getAllTrackFromWishList()).thenReturn(trackList);
   mockMvc.perform(get("/api/v1/muzixservice/tracks")
           .contentType(MediaType.APPLICATION_JSON)
           .content(jsonToString(track)))
           .andExpect(status().isOk())
           .andDo(print());
}

private static String jsonToString(final Object ob) throws JsonProcessingException {
   String result;

   try {
       ObjectMapper mapper = new ObjectMapper();
       String jsonContent = mapper.writeValueAsString(ob);
       result = jsonContent;
   } catch(JsonProcessingException e) {
       result = "JSON processing error";
   }

   return result;
}
