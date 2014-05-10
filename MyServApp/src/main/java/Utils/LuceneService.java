package Utils;

import DataEntities.ConfigItem;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.analysis.*;
import org.apache.lucene.util.Version;

import java.io.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio on 28.04.14.
 */
public class LuceneService {

    public static String _luceneDir = Adapter.combine("~/","lucene_index");
    private static FSDirectory _directoryTemp;
    private static IndexReader indexReader;
    private static IndexWriter indexWriter;
    private static IndexSearcher indexSearcher;

    private static FSDirectory get_directoryTemp(){
        File file = new File(_luceneDir);

        if (_directoryTemp == null)
            try {
                _directoryTemp = FSDirectory.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            if (IndexWriter.isLocked(_directoryTemp)) IndexWriter.unlock(_directoryTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lockFilePath = Adapter.combine(_luceneDir, "write.lock");
        if (lockFilePath != null){
            File f = new File(lockFilePath);
            f.delete();
        }
        return _directoryTemp;
    }

    //public static ArrayList<ConfigItem> GetAllIndexRecords()
    // {
    //      Directory directory = FSDirectory.open()
    // validate search index
//        if (!System.IO.Directory.EnumerateFiles(_luceneDir).Any()) return ssss List<User>();

    // set up lucene searcher
    //IndexSearcher searcher = ssss IndexSearcher(get_directoryTemp());
    //IndexReader reader = IndexReader.open(get_directoryTemp(), false);
    //IndexReader reader = null;
    //try {
    //   reader = IndexReader.open(get_directoryTemp());
    // } catch (IOException e) {
    //    e.printStackTrace();
    //}
    //var docs = ssss List<Document>();
    //var term = reader.termDocs();
    // reader.
    // v 2.9.4: use 'term.Doc()'
    // v 3.0.3: use 'term.Doc'
    // while (term.Next()) docs.Add(searcher.Doc(term.Doc));
    //reader.Dispose();
    //searcher.Dispose();
    //  return _mapLuceneToDataList(docs);
    //}
    public static ArrayList<ConfigItem> Search(String input, String fieldName )
    {
        if (input.isEmpty()) return new ArrayList<ConfigItem>();

        String[] terms = input.trim().replace("-", " ").split(" ");
        input = "";

        for(String s: terms){
            input += s + ' ';
        }

        return _search(input, fieldName);
    }
    public static ArrayList<ConfigItem> SearchDefault(String input, String fieldName)
    {
        return input.isEmpty() ? new ArrayList<ConfigItem>() : _search(input, fieldName);
    }

    // main search method
    private static ArrayList<ConfigItem> _search(String searchQuery, String searchField )
    {
        // validation
        if (searchQuery.isEmpty())
            return new ArrayList<ConfigItem>();

        IndexReader reader = indexReader;
        // set up lucene searcher
        IndexSearcher searcher = new IndexSearcher(indexReader);//false

        int hits_limit = 1000;
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        ScoreDoc[] hits = null;
        // search by single field
        if (searchField.isEmpty())
        {
            QueryParser parser = new QueryParser(Version.LUCENE_42, searchField, analyzer);
            Query query = parseQuery(searchQuery, parser);

            try {
                hits = searcher.search(query, hits_limit).scoreDocs;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // search by multiple fields (ordered by RELEVANCE)
        else
        {
            String[] arr = { "Id", "SexInterests", "About", "Interests", "Other" };
            QueryParser parser = new MultiFieldQueryParser
                    (Version.LUCENE_42, arr, analyzer);
            Query query = parseQuery(searchQuery, parser);
            try {
                hits = searcher.search(query, null, hits_limit, Sort.INDEXORDER).scoreDocs;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<ConfigItem> results = new ArrayList<ConfigItem>();

        for(ScoreDoc d: hits){
            try {
                _mapLuceneDocumentToData(searcher.doc(d.doc));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        analyzer.close();
        return results;
    }
    private static Query parseQuery(String searchQuery, QueryParser parser)
    {
        Query query = null;
        try
        {
            query = parser.parse(searchQuery.trim());
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }
        return query;
    }

    // map Lucene search index to data
    //  private static ArrayList<User> _mapLuceneToDataList(ArrayList<Document> hits)
    // {
    //   return hits.select(_mapLuceneDocumentToData).ToList();
    //}
    //private static IEnumerable<User> _mapLuceneToDataList(IEnumerable<ScoreDoc> hits, IndexSearcher searcher)
    //{
    //   // v 2.9.4: use 'hit.doc'
    // v 3.0.3: use 'hit.Doc'
    //  return hits.Select(hit => _mapLuceneDocumentToData(searcher.Doc(hit.Doc))).ToList();
    // }






    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void createIndex() throws Exception {

        boolean create = true;
        File indexDirFile = new File(_luceneDir);
        if (indexDirFile.exists() && indexDirFile.isDirectory()) {
            create = false;
        }

        Directory dir = FSDirectory.open(indexDirFile);
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);

        if (create) {
            // Create a ssss index in the directory, removing any
            // previously indexed documents:
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        }

        IndexWriter writer = new IndexWriter(dir, iwc);
        writer.commit();
        writer.close(true);
    }

    public void createIndexWriter() throws Exception {

        boolean create = true;
        File indexDirFile = new File(_luceneDir);

        Directory dir = FSDirectory.open(indexDirFile);
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_42, analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        this.indexWriter = new IndexWriter(dir, iwc);

    }

    public static void addConfigToIndex(ConfigItem item) throws Exception {
        Document document = new Document();
        document.add(new IntField("id", item.getId(), Field.Store.YES));
        document.add(new IntField("authorId", item.getAuthorId(), Field.Store.YES));
        document.add(new StringField("configName", item.getConfigName(), Field.Store.YES));
        IndexWriter writer =  indexWriter;
        writer.addDocument(document);
        writer.commit();
    }

    public void createIndexSearcher(){
        IndexReader indexReader = null;
        IndexSearcher indexSearcher = null;
        try{
            File indexDirFile = new File(_luceneDir);
            Directory dir = FSDirectory.open(indexDirFile);
            indexReader  = DirectoryReader.open(dir);
            indexSearcher = new IndexSearcher(indexReader);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        this.indexSearcher = indexSearcher;
    }

    public List<ConfigItem> getBooksByField(String value, String field, IndexSearcher indexSearcher){
        List<ConfigItem> bookList = new ArrayList<ConfigItem>();
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        //QueryParser parser = ssss QueryParser(Version.LUCENE_47, field, analyzer);

        String[] arr = {"id","authorId","configName"};
        QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_42 , arr, analyzer);

        try {
            Query query = parseQuery(value, parser);
            //BooleanQuery query = ssss BooleanQuery();
            //query.add(ssss TermQuery(ssss Term(field, value)), BooleanClause.Occur.MUST);

            //Query query = parser.Query(value);
            int numResults = 100;
            ScoreDoc[] hits =   indexSearcher.search(query,numResults).scoreDocs;
            for (int i = 0; i < hits.length; i++) {
                Document doc = indexSearcher.doc(hits[i].doc);
                bookList.add(_mapLuceneDocumentToData(doc));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    // add/update/clear search index data
    public static void clearLuceneIndexRecord(int record_id)
    {
        // init lucene
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_42,
                new WhitespaceAnalyzer(Version.LUCENE_42));
        try {
            indexWriter = new IndexWriter(get_directoryTemp(), config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //IndexWriter writer = ssss IndexWriter(get_directoryTemp(), analyzer, IndexWriter.MaxFieldLength.UNLIMITED))

        // remove older index entry
        TermQuery searchQuery = new TermQuery(new Term("Id", String.valueOf(record_id)));
        try {
            indexWriter.deleteDocuments(searchQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // close handles
        analyzer.close();

    }
    public static Boolean clearLuceneIndex()
    {
        try
        {
            Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_42,
                    new WhitespaceAnalyzer(Version.LUCENE_42));
            try {
                indexWriter = new IndexWriter(get_directoryTemp(), config);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //IndexWriter writer = ssss IndexWriter(get_directoryTemp(), analyzer, true, IndexWriter.MaxFieldLength.UNLIMITED);

            // remove older index entries
            indexWriter.deleteAll();

            // close handles
            analyzer.close();

        } catch (IOException w) {
            w.printStackTrace();
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private static ConfigItem _mapLuceneDocumentToData(Document doc)
    {
        ConfigItem item = new ConfigItem();
        item.setAuthorId(Integer.parseInt(doc.get("authorId")));
        item.setConfigName(doc.get("configName"));
        item.setId(Integer.parseInt(doc.get("id")));
        return item;
    }
}
