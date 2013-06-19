package com.setantamedia.fulcrum.ws;

import com.setantamedia.fulcrum.AdvancedServer;
import com.setantamedia.fulcrum.CoreServer;
import com.setantamedia.fulcrum.DamManager;
import com.setantamedia.fulcrum.common.*;
import com.setantamedia.fulcrum.config.View;
import com.setantamedia.fulcrum.db.DbManager;
import com.setantamedia.fulcrum.db.DbSessionData;
import com.setantamedia.fulcrum.models.core.Person;
import static com.setantamedia.fulcrum.ws.BaseServlet.PARAMETER_CONNECTION_POOLSIZE;
import static com.setantamedia.fulcrum.ws.BaseServlet.PARAMETER_PASSWORD;
import static com.setantamedia.fulcrum.ws.BaseServlet.PARAMETER_USERNAME;
import static com.setantamedia.fulcrum.ws.WorkflowServlet.DIS_DB_NAME;
import com.setantamedia.fulcrum.ws.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("serial")
/**
 * Handle preview requests: GET http://localhost/disweb/admin/sample/describe
 */
public class AdminServlet extends BaseServlet {

    private final static Logger logger = Logger.getLogger(AdminServlet.class);
    public final static String SERVICE_NAME = "admin";
    public final static String OP_USER_VALIDATE = "validate";
    public final static String OP_USER_ACTIVATE = "activate";
    public final static String URL_PARAM_USERNAME = "s";
    public final static String URL_PARAM_PASSWORD = "g";
    public final static String URL_PARAM_ACTIVE = "active";
    public final static String URL_PARAM_ACCESS_CODE = "access-code";
    public final static String JSON_FIELD_KEY_NAME = "name";
    public final static String JSON_FIELD_KEY_SIMPLE_NAME = "simpleName";
    public final static String JSON_FIELD_KEY_DISPLAY_NAME = "displayName";
    public final static String JSON_FIELD_KEY_CORE_FIELD = "coreField";
    public final static String JSON_FIELD_KEY_GUID = "guid";
    public final static String JSON_FIELD_KEY_DATA_TYPE = "dataType";
    public final static String JSON_FIELD_VIEW_NAMES = "viewNames";
    public final static String JSON_FIELD_KEY_VALUE_INTERPRETATION = "valueInterpretation";
    public final static String JSON_FIELD_KEY_TABLE_COLUMNS = "tableColumns";
    public final static String JSON_FIELD_KEY_LIST_VALUES = "listValues";
    public final static String JSON_FIELD_KEY_LIST_MULTI_SELECT = "multiSelect";
    public final static String DIS_DB_CONNECTION_NAME = "dis-db";
    private DbManager disDbManager = null;
    private CoreServer server = null;
    private HashMap<String, Database> databases = null;

    private enum Operations {

        terminate, describe, describequeries, startsession, endsession, activateuser, getuser, singlesignon, updateuser,
        createproject, openconnection, closeconnection
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        server = (CoreServer) context.getAttribute(FulcrumServletContextListener.MAIN_SERVER);
        if (server instanceof AdvancedServer) {
            databases = ((AdvancedServer) server).getDatabases();
            disDbManager = databases.get(DIS_DB_NAME).getManager();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = HttpServletResponse.SC_NOT_FOUND;
        try {
            String[] pathElements = getPathElements(request);
            String requestUrl = request.getRequestURL().toString() + "/" + request.getQueryString();
            if (pathElements.length < 3) {
                logger.error("Invalid admin service request: " + requestUrl);
                throw new Exception("Invalid admin service request: " + requestUrl);
            }
            serviceName = SERVICE_NAME;
            connectionName = pathElements[1];
            operationName = pathElements[2];
            // do access control
            if (!requestAllowed(request.getRemoteAddr())) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            /*
             * String localAddress = request.getLocalAddr(); String remoteAddress = request.getRemoteAddr(); String
             * remoteHost = request.getRemoteHost();
             */

            /*
             * HttpSession session = request.getSession(false); if ((session == null ||
             * session.getAttribute(DbManager.DB_SESSION_DATA) == null) &&
             * !operationName.equals(Operations.startsession.toString())) { status = HttpServletResponse.SC_UNAUTHORIZED;
             * response.setStatus(status); return; }
             *
             * if (!operationName.equals(Operations.startsession.toString())) { sessionData = (DbSessionData)
             * session.getAttribute(DbManager.DB_SESSION_DATA); }
             */

            if (operationName.equals(Operations.openconnection.toString())) {
                // we ned to determine how to do authentication - use the DIS database
                DbSessionData sessionData = null;
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute(DbManager.DB_SESSION_DATA) == null) {
                    String username = request.getParameter(PARAMETER_USERNAME);
                    String password = request.getParameter(PARAMETER_PASSWORD);
                    if (username != null && password != null) {
                        sessionData = disDbManager.login(DIS_DB_NAME, DIS_DB_CONNECTION_NAME, username, password);
                    }
                    if (sessionData == null) {
                        status = HttpServletResponse.SC_UNAUTHORIZED;
                        response.setStatus(status);
                        return;
                    }
                } else {
                    sessionData = (DbSessionData) session.getAttribute(DbManager.DB_SESSION_DATA);
                }
                String connectionUsername = request.getParameter(PARAMETER_CONNECTION_USERNAME);
                String connectionPassword = request.getParameter(PARAMETER_CONNECTION_PASSWORD);
                Integer connectionPoolSize = (request.getParameter(PARAMETER_CONNECTION_POOLSIZE) != null) ? new Integer(request.getParameter(PARAMETER_CONNECTION_POOLSIZE)) : -1;
                if (dam.manager.openConnection(dam.connections.get(connectionName), connectionUsername, connectionPassword, connectionPoolSize)) {
                    status = HttpServletResponse.SC_OK;
                } else {
                    status = HttpServletResponse.SC_EXPECTATION_FAILED;
                }
            } else if (operationName.equals(Operations.closeconnection.toString())) {
                // we ned to determine how to do authentication - use the DIS database 
                DbSessionData sessionData = null;
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute(DbManager.DB_SESSION_DATA) == null) {
                    String username = request.getParameter(PARAMETER_USERNAME);
                    String password = request.getParameter(PARAMETER_PASSWORD);
                    if (username != null && password != null) {
                        sessionData = disDbManager.login(DIS_DB_NAME, DIS_DB_CONNECTION_NAME, username, password);
                    }
                    if (sessionData == null) {
                        status = HttpServletResponse.SC_UNAUTHORIZED;
                        response.setStatus(status);
                        return;
                    }
                } else {
                    sessionData = (DbSessionData) session.getAttribute(DbManager.DB_SESSION_DATA);
                }
                if (dam.manager.closeConnection(dam.connections.get(connectionName))) {
                    status = HttpServletResponse.SC_OK;
                } else {
                    status = HttpServletResponse.SC_EXPECTATION_FAILED;
                }
            } else if (operationName.equals(Operations.describe.toString())) {
                String outputFormat = (request.getParameter(PARAMETER_FORMAT) != null) ? request.getParameter(PARAMETER_FORMAT) : FORMAT_JSON;
                String viewName = (request.getParameter(PARAMETER_VIEW) != null) ? request.getParameter(PARAMETER_VIEW) : null;
                if (viewName != null) {
                    if (FORMAT_JSON.equals(outputFormat)) {
                        HashMap<String, Object> allFields = describeAsJson(response, dam.connections.get(connectionName), viewName);
                        if (allFields != null && allFields.size() > 0) {
                            response.setCharacterEncoding(UTF_8);
                            response.setContentType("application/json;charset=UTF-8");
                            response.getWriter().write((new JSONObject(allFields)).toString());
                            response.getWriter().flush();
                            response.getWriter().close();
                            status = HttpServletResponse.SC_OK;
                        } else {
                            status = HttpServletResponse.SC_NO_CONTENT;
                        }
                    } else if (FORMAT_CSHARP.equals(outputFormat)) {
                    }
                } else {
                    if (FORMAT_JSON.equals(outputFormat)) {
                        HashMap<String, Map<String, Object>> allViewFields = describeAllAsJson(response, dam.manager, dam.connections.get(connectionName));
                        response.setCharacterEncoding(UTF_8);
                        response.setContentType("application/json;charset=UTF-8");
                        response.getWriter().write((new JSONObject(allViewFields)).toString());
                        response.getWriter().flush();
                        response.getWriter().close();
                        status = HttpServletResponse.SC_OK;
                    } else if (FORMAT_CSHARP.equals(outputFormat)) {
                    }
                }
            } else if (operationName.equals(Operations.describequeries.toString())) {
                String outputFormat = (request.getParameter(PARAMETER_FORMAT) != null) ? request.getParameter(PARAMETER_FORMAT) : FORMAT_JSON;
                if (FORMAT_JSON.equals(outputFormat)) {
                    //DatabaseQuery[] queries = describeQueriesAsJson(response, dam.manager, dam.connections.get(connectionName));
                    response.setCharacterEncoding(UTF_8);
                    response.setContentType("application/json;charset=UTF-8");
                    //response.getWriter().write((new JSONObject(queries)).toString());
                    response.getWriter().flush();
                    response.getWriter().close();
                    status = HttpServletResponse.SC_OK;
                }
            } else if (operationName.equals(Operations.startsession.toString())) {
                boolean authenticate = false;
                String username = (request.getParameter(PARAMETER_USERNAME) != null) ? request.getParameter(PARAMETER_USERNAME) : null;
                String password = (request.getParameter(PARAMETER_PASSWORD) != null) ? request.getParameter(PARAMETER_PASSWORD) : null;
                connectionName = (request.getParameter(PARAMETER_CONNECTION) != null) ? request.getParameter(PARAMETER_CONNECTION) : null;
                //Boolean readOnly = (Utilities.isTrue(request.getParameter(PARAMETER_READ_ONLY)));
                if (username != null && password != null && connectionName != null) {
                    authenticate = true;
                }
                HttpSession session = request.getSession(true);
                boolean authenticated = false;
                if (authenticate) {
                }

                HashMap<String, Object> jsonData = new HashMap<>();
                jsonData.put("sessionid", session.getId());
                jsonData.put("authenticate", authenticate);
                if (authenticate) {
                    jsonData.put("authenticated", authenticated);
                }
                response.setCharacterEncoding(UTF_8);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write((new JSONObject(jsonData)).toString());
                response.getWriter().flush();
                response.getWriter().close();
                status = HttpServletResponse.SC_OK;
            } else if (operationName.equals(Operations.endsession.toString())) {
                request.getSession(true).invalidate();
                status = HttpServletResponse.SC_OK;
            } else if (operationName.equals(Operations.activateuser.toString())) {
                Boolean activate = null;
                String username = null;
                if (request.getParameter(URL_PARAM_ACTIVE) != null) {
                    activate = Boolean.valueOf(request.getParameter(URL_PARAM_ACTIVE));
                    username = request.getParameter(URL_PARAM_USERNAME);
                }
                User user = doActivateUser(dam.connections.get(connectionName), username, activate);
                if (user != null) {
                    response.setCharacterEncoding(UTF_8);
                    response.setContentType("application/json;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.write(new JSONObject(user).toString());
                        out.flush();
                    }
                    status = HttpServletResponse.SC_OK;
                } else {
                    status = HttpServletResponse.SC_FORBIDDEN;
                }
            } else if (operationName.equals(Operations.updateuser.toString())) {
            } else if (operationName.equals(Operations.getuser.toString())) {
                String username = request.getParameter(URL_PARAM_USERNAME);
                String password = request.getParameter(URL_PARAM_PASSWORD);
                User user = doGetUser(dam.connections.get(connectionName), username, password);
                if (user != null) {
                    HttpSession session = request.getSession(true);
                    Session sessionData = new Session();
                    user.setSessionId(session.getId());
                    sessionData.setUser(user);
                    sessionData.setConnection(dam.connections.get(connectionName));
                    sessionData.setTicket(user.getTicket());
                    sessionData.setValid(true);
                    sessionData.setSessionId(session.getId());
                    session.setAttribute(Common.FULCRUM_SESSION_DATA, sessionData);

                    response.setCharacterEncoding(UTF_8);
                    response.setContentType("application/json;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.write(new JSONObject(user).toString());
                        out.flush();
                    }
                    status = HttpServletResponse.SC_OK;
                } else {
                    status = HttpServletResponse.SC_FORBIDDEN;
                }
            } else if (operationName.equals(Operations.singlesignon.toString())) {
                String username = request.getParameter(URL_PARAM_USERNAME);
                User user = doSingleSignOn(dam.connections.get(connectionName), username);
                if (user != null) {
                    response.setCharacterEncoding(UTF_8);
                    response.setContentType("application/json;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.write(new JSONObject(user).toString());
                        out.flush();
                    }
                    status = HttpServletResponse.SC_OK;
                } else {
                    status = HttpServletResponse.SC_FORBIDDEN;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.setStatus(status);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = HttpServletResponse.SC_NOT_FOUND;
        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute(Common.FULCRUM_SESSION_DATA) == null) {
                status = HttpServletResponse.SC_UNAUTHORIZED;
                response.setStatus(status);
                return;
            }
            Session sessionData = (Session) session.getAttribute(Common.FULCRUM_SESSION_DATA);
            String[] pathElements = getPathElements(request);
            if (pathElements.length < 3) {
                logger.error("Invalid admin service request");
                throw new Exception("Invalid admin service request");
            }
            serviceName = SERVICE_NAME;
            connectionName = pathElements[1];
            operationName = pathElements[2];
            // do access control
            if (!requestAllowed(request.getRemoteAddr())) {
                status = HttpServletResponse.SC_UNAUTHORIZED;
            }
            User user = sessionData.getUser();
            /*
            if (operationName.equals(Operations.createproject.toString())) {
                String projectName = request.getParameter(FULCRUM_PREFIX + PARAM_PROJECTNAME);
                Project project = dam.manager.createProject(dam.connections.get(connectionName), user, projectName);
                if (project != null) {
                    response.setCharacterEncoding(UTF_8);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write((new JSONObject(project)).toString());
                    response.getWriter().flush();
                    response.getWriter().close();
                    status = HttpServletResponse.SC_OK;
                } else {
                    // TODO best to return status via JSON
                }
             }
             */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.setStatus(status);
        }
    }

    private User doActivateUser(Connection connection, String username, Boolean activate) {
        User result = null;
        if (activate != null) {
            try {
                if (!dam.manager.activateUser(connection, username, activate)) {
                    if (activate) {
                        logger.info("attempt to activate user: " + username + " failed");
                    } else {
                        logger.info("attempt to deactivate user: " + username + " failed");
                    }
                } else {
                    result = new User();
                    result.setUsername(username);
                    result.setLoginActive(activate);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private User doSingleSignOn(Connection connection, String username) {
        User result = null;
        try {
            Person person = dam.manager.userSingleSignOn(connection, username);
            if (person != null) {
                result = new User();
                result.setEmail(person.getEmail());
                result.setFirstName(person.getFirstName());
                result.setLastName(person.getLastName());
                result.setLoginActive(person.getLoginActive());
                result.setUsername(person.getUsername());
                result.setFields(person.getFields());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private User doGetUser(Connection connection, String username, String password) {
        User result = null;
        try {
            Person person = dam.manager.getUser(connection, username, password);
            if (person != null) {
                result = new User();
                result.setEmail(person.getEmail());
                result.setFirstName(person.getFirstName());
                result.setLastName(person.getLastName());
                result.setLoginActive(person.getLoginActive());
                result.setUsername(person.getUsername());
                result.setAdminUser(person.getAdminUser());
                result.setGuestUser(person.getGuestUser());
                result.setTicket(person.getTicket());
                result.setFields(person.getFields());
                result.setSites(person.getSites());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private HashMap<String, Map<String, Object>> describeAllAsJson(HttpServletResponse response, DamManager manager, Connection connection) throws Exception {
        HashMap<String, Map<String, Object>> result = new HashMap<>();
        for (View view : manager.getViews().values()) {
            result.put(view.getName(), describeAsJson(response, connection, view.getName()));
        }
        return result;
    }

    private HashMap<String, Object> describeAsJson(HttpServletResponse response, Connection connection, String viewName) throws Exception {
        HashMap<String, Object> result = null;
        DatabaseField[] fields = dam.manager.getFields(connection, viewName);
        if (fields != null) {
            List<JSONObject> jsonFields = new ArrayList<>();
            result = new HashMap<>();
            for (DatabaseField field : fields) {
                HashMap<String, Object> fieldMap = new HashMap<>();
                fieldMap.put(JSON_FIELD_KEY_NAME, field.getName());
                fieldMap.put(JSON_FIELD_KEY_SIMPLE_NAME, field.getSimpleName());
                fieldMap.put(JSON_FIELD_KEY_DISPLAY_NAME, field.getDisplayName());
                fieldMap.put(JSON_FIELD_KEY_CORE_FIELD, field.getCoreField());
                fieldMap.put(JSON_FIELD_KEY_GUID, field.getGuid());
                fieldMap.put(JSON_FIELD_KEY_DATA_TYPE, field.getDataType());
                fieldMap.put(JSON_FIELD_KEY_VALUE_INTERPRETATION, field.getValueInterpretation());
                if (field.isSelect()) {
                    StringListValue[] slv = field.getListValues();
                    JSONObject[] lvs = new JSONObject[slv.length];
                    int i = 0;
                    for (StringListValue v : slv) {
                        lvs[i++] = new JSONObject(v);
                    }
                    fieldMap.put(JSON_FIELD_KEY_LIST_VALUES, new JSONArray(lvs));
                }
                fieldMap.put(JSON_FIELD_KEY_LIST_MULTI_SELECT, field.isMultiSelect());
                jsonFields.add(new JSONObject(fieldMap));
            }
            result.put("fields", new JSONArray(jsonFields));

            // previews, links and references
            result.put("previews", new JSONObject(dam.manager.getPreviews(connection, viewName)));
            result.put("links", new JSONObject(dam.manager.getLinks(connection, viewName)));
            result.put("references", new JSONObject(dam.manager.getReferences(connection, viewName)));
            result.put("name", viewName);
        }
        return result;
    }

    public class CSharpHelper {

        public SimpleDateFormat timeFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");

        public CSharpHelper() {
        }

        public void describeAsCsharp(HttpServletResponse response, String databaseName, String viewName, boolean isRecordView) throws Exception {
            DatabaseField[] fieldDescriptors = dam.manager.getFields(dam.connections.get(databaseName), viewName);

            PrintWriter printWriter = new PrintWriter(response.getWriter());
            printWriter.println("/*");
            printWriter.println(" * This code was automatically generated by the DAFT Server.");
            printWriter.println(" * Use this code in a C# project to access data returned by DAFT Server, based pre-configured views.");
            printWriter.println(" * Requires .NET Framework 3.5 or later, and classes can be used in LINQ based applications.");
            printWriter.println(" *");
            printWriter.println(new StringBuilder().append(" *    Generated at: ").append(timeFormat.format(Calendar.getInstance().getTime())).toString());
            printWriter.println(new StringBuilder().append(" *    Catalog Name: ").append(databaseName).toString());
            printWriter.println(new StringBuilder().append(" *    View name: ").append(viewName).toString());
            printWriter.println(" *");
            printWriter.println(" * It is strongly recommended that you do not manually edit this code.");
            printWriter.println(" * If you do manually edit the code, data returned from DAFT Server may not map correctly onto your class objects.");
            printWriter.println(" *");
            printWriter.println(" */");
            printWriter.println("using System;");
            printWriter.println("using Daft.lib;");
            printWriter.println("");
            printWriter.println("namespace Daft.lib.metadata.views");
            printWriter.println("{");

            //printWriter.println(makeCsharpClass(viewName, new StringBuilder().append(isRecordView ? "RecordView_" : "CategoryView_").append(firstUpper(viewName)).toString(), fieldDescriptors, (AbstractMap.SimpleEntry[]) ((Map) this.urlFields.get(databaseName)).get(viewName), (String[]) ((Map) this.refFields.get(databaseName)).get(viewName)));

            printWriter.println("}");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=UTF-8");
            response.setStatus(200);
        }

        public void describeAllAsCsharp(HttpServletResponse response, String databaseName) throws Exception {
            PrintWriter printWriter = new PrintWriter(response.getWriter());
            printWriter.println("/*");
            printWriter.println(" * This code was automatically generated by the DAFT Server.");
            printWriter.println(" * Use this code in a C# project to access data returned by DAFT Server, based pre-configured views.");
            printWriter.println(" * Requires .NET Framework 3.5 or later, and classes can be used in LINQ based applications.");
            printWriter.println(" *");
            printWriter.println(new StringBuilder().append(" *    Generated at: ").append(this.timeFormat.format(Calendar.getInstance().getTime())).toString());
            printWriter.println(new StringBuilder().append(" *    Catalog Name: ").append(databaseName).toString());
            printWriter.println(" *");
            printWriter.println(" * It is strongly recommended that you do not manually edit this code.");
            printWriter.println(" * If you do manually edit the code, data returned from DAFT Server may not map correctly onto your class objects.");
            printWriter.println(" *");
            printWriter.println(" */");
            printWriter.println("using System;");
            printWriter.println("using Daft.lib;");
            printWriter.println("");
            printWriter.println("namespace Daft.lib.metadata.views");
            printWriter.println("{");

            HashMap<String, String> tableClasses = makeCsharpTableClasses(dam.connections.get(databaseName));
            printWriter.println("   // Table field definitions");
            printWriter.println("");
            for (Map.Entry<String, String> entry : tableClasses.entrySet()) {
                printWriter.println(new StringBuilder().append("   // ").append(entry.getKey()).toString());
                printWriter.println(entry.getValue());
            }
            printWriter.println("");
            printWriter.println("   // View definitions");
            printWriter.println("");
            /*
             * for (Map.Entry<String, DatabaseField[]> entries : recordFieldDescriptors.get(databaseName).entrySet()) { if
             * ("all".equals(entries.getKey())) { continue; } printWriter.println(makeCsharpClass((String)
             * entries.getKey(), new StringBuilder().append("RecordView_").append(firstUpper((String)
             * entries.getKey())).toString(), (DamFieldDefinition[]) entries.getValue(), (AbstractMap.SimpleEntry[]) ((Map)
             * this.urlFields.get(catalogName)).get(entries.getKey()), (String[]) ((Map)
             * this.refFields.get(catalogName)).get(entries.getKey()))); }
             */

            printWriter.println("}");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=UTF-8");
            response.setStatus(200);
        }

        private HashMap<String, String> makeCsharpTableClasses(Connection connection) throws Exception {
            HashMap result = new HashMap();
            /*
             * HashMap<String, DatabaseTable> tableFields =
             * getBean(connection.getBeanName()).getCatalogTableFields(connection); if (tableFields != null) { for
             * (Map.Entry entry : tableFields.entrySet()) { result.put(((DatabaseTable) entry.getValue()).getName(),
             * makeCsharpTableClass(((DatabaseTable) entry.getValue()).getName(), (DatabaseTable) entry.getValue())); } }
             */
            return result;
        }

        private String makeCsharpTableClass(String fieldName, DatabaseTable tableField) throws Exception {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);

            printWriter.println(new StringBuilder().append("   public class Metadata_Table_").append(firstUpper(Utilities.normaliseFieldName(fieldName))).toString());
            printWriter.println("   {");
            for (DatabaseField field : tableField.getColumns()) {
                if (("ID".equals(field.getName())) || ("Record Name".equals(field.getName()))) {
                    continue;
                }

                String varName = firstLower(field.getSimpleName());
                String varType = getCsharpType(field);
                printWriter.println(new StringBuilder().append("      public ").append(varType).append(" ").append(firstUpper(varName)).append(" { get; set; }").toString());
                printWriter.println("");
            }
            printWriter.println("   }");
            stringWriter.close();
            printWriter.close();
            return stringWriter.toString();
        }

        private String makeCsharpClass(String viewName, String className, DatabaseField[] fieldDescriptors, AbstractMap.SimpleEntry[] urls, String[] refs) throws Exception {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println(new StringBuilder().append("   public class Metadata_").append(className).append(" : DamAsset").toString());
            printWriter.println("   {");

            printWriter.println(new StringBuilder().append("      public const string VIEW_NAME = \"").append(viewName).append("\";").toString());
            printWriter.println("");
            for (DatabaseField field : fieldDescriptors) {
                if (("ID".equals(field.getName())) || ("Record Name".equals(field.getName()))) {
                    continue;
                }

                String varName = firstLower(field.getSimpleName());
                String varType = getCsharpType(field);
                printWriter.println(new StringBuilder().append("      public ").append(varType).append(" ").append(firstUpper(varName)).append(" { get; set; }").toString());
                if ((field.isSimpleSelect()) || (field.isMultiSelect())) {
                    printWriter.println(new StringBuilder().append("      public static DamStringEnum[] ").append(firstUpper(varName)).append("_Values").append(" = {").toString());
                    for (int i = 0; i < field.getListValues().length; i++) {
                        if (i == field.getListValues().length - 1) {
                            printWriter.println(new StringBuilder().append("         new DamStringEnum(").append(field.getListValues()[i].getId()).append(", \"").append(field.getListValues()[i].getDisplayString()).append("\")").toString());
                        } else {
                            printWriter.println(new StringBuilder().append("         new DamStringEnum(").append(field.getListValues()[i].getId()).append(", \"").append(field.getListValues()[i].getDisplayString()).append("\"),").toString());
                        }
                    }
                    printWriter.println("      };");
                } else if (field.isLabelSelect()) {
                    printWriter.println(new StringBuilder().append("      public static DamStringEnumLabel[] ").append(firstUpper(varName)).append("_Values").append(" = {").toString());
                    for (int i = 0; i < field.getListValues().length; i++) {
                        int color = ((LabelValue) field.getListValues()[i]).getColor();
                        if (i == field.getListValues().length - 1) {
                            printWriter.println(new StringBuilder().append("         new DamStringEnumLabel(").append(field.getListValues()[i].getId()).append(", \"").append(field.getListValues()[i].getDisplayString()).append("\", ").append(color).append(")").toString());
                        } else {
                            printWriter.println(new StringBuilder().append("         new DamStringEnumLabel(").append(field.getListValues()[i].getId()).append(", \"").append(field.getListValues()[i].getDisplayString()).append("\", ").append(color).append("),").toString());
                        }
                    }
                    printWriter.println("      };");
                }

                printWriter.println("");
            }

            if (urls != null) {
                for (int i = 0; i < urls.length; i++) {
                    printWriter.println(new StringBuilder().append("      public string ").append(firstUpper((String) urls[i].getKey())).append(" { get; set; }").toString());
                }
                printWriter.println("");
            }
            if (refs != null) {
                for (int i = 0; i < refs.length; i++) {
                    printWriter.println(new StringBuilder().append("      public string ").append(firstUpper(refs[i])).append(" { get; set; }").toString());
                }
            }

            printWriter.println("   }");
            stringWriter.close();
            printWriter.close();
            return stringWriter.toString();
        }

        public String firstUpper(String value) {
            String result = value;
            if (Character.isLowerCase(result.charAt(0))) {
                char[] cs = result.toCharArray();
                cs[0] = Character.toUpperCase(cs[0]);
                result = String.valueOf(cs);
            }
            return result;
        }

        public String firstLower(String value) {
            String result = value;
            if (Character.isUpperCase(result.charAt(0))) {
                char[] cs = result.toCharArray();
                cs[0] = Character.toLowerCase(cs[0]);
                result = String.valueOf(cs);
            }
            return result;
        }

        private String getCsharpType(DatabaseField field) {
            String result = "string";
            switch (field.getDataType().intValue()) {
                case 0:
                    result = "string";
                    break;
                case 1:
                    result = "bool";
                    break;
                case 2:
                    result = "int";
                    break;
                case 9:
                    switch (field.getValueInterpretation().intValue()) {
                        case 0:
                            result = "long";
                            break;
                        case 4:
                            result = "DamDataSize";
                            break;
                        default:
                            result = "long";
                    }
                    break;
                case 4:
                    result = "DateTime";
                    break;
                case 7:
                    switch (field.getValueInterpretation().intValue()) {
                        case 0:
                            result = "DamStringEnum";
                            break;
                        case 7:
                            result = "DamStringEnum[]";
                            break;
                        case 8:
                            result = "DamStringEnumLabel";
                    }

                    break;
                case 10:
                    result = new StringBuilder().append("Metadata_Table_").append(firstUpper(field.getSimpleName())).append("[]").toString();
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
            }
            return result;
        }
    }
}
