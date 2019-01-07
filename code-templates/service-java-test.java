
public class MuzixServiceTest {

   @Mock
   private MuzixRepository muzixRepository;

    private Image image;
    private Artist artist;
    private Track track;
   private Optional optional;

   private List<Track> listTrack=null;

   @InjectMocks
   private MuzixServiceImpl muzixService;

@Before
public void setUp(){
   MockitoAnnotations.initMocks(this);

   image  = new Image(1,"http:url","large");
   Artist = new Artist(101,"Jonhn","new url",image);
   track  = new Track("Track1","Mynewtrack","new comments",123,"new track url",artist);
   listTrack = new ArrayList<>();

   listTrack.add(track);
   optional = Optional.of(track);
}

@After
public void tearDown(){
   image = null;
   artist = null;
   track = null;
}

@Test
public void testSaveTrackSuccess() throws TrackAlreadyExistException {
   when(muzixRepository.insert(track)).thenReturn(track);

   Track fetchTrack = muzixService.saveTrackToWishList(track);
   Assert.assertEquals(track,fetchTrack);

   verify(muzixRepository,times(1)).insert(track);
   verify(muzixRepository,times(1)).findById(track.getTrackId());

}

@Test
public void testUpdateCommentsSuccess() throws TrackNotFoundException {

when(muzixRepository.findById(track.getTrackId())).thenReturn(optional);
   track.setComments("comments updated");
   Track fetchTrack = muzixService.updateCommentForTrack(track.getComments(),track.getTrackId());
   Assert.assertEquals(fetchTrack.getComments() ,"comments updated" );

   verify(muzixRepository,times(1)).save(track);
   verify(muzixRepository,times(2)).findById(track.getTrackId());
}

@Test
public void testDeleteTrack() throws TrackNotFoundException {
   when(muzixRepository.findById(track.getTrackId())).thenReturn(optional);
   boolean fetchTrack = muzixService.deleteTrackFromWishList(track.getTrackId());
   Assert.assertEquals(true,fetchTrack);
verify(muzixRepository,times(1)).findById(track.getTrackId());
   verify(muzixRepository,times(1)).deleteById(track.getTrackId());
}


@Test
public void testGetAllTrack() throws Exception {
   when(muzixRepository.findAll()).thenReturn(listTrack);
   List<Track> list = muzixService.getAllTrackFromWishList();
   Assert.assertEquals(list,listTrack);
verify(muzixRepository,times(1)).findAll();

}
}
