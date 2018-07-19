# Major Selection

Set the minimum required SDK to API 19 (Android 4.4 KitKat) and target Pixel.<br>
Collect the basic information about the user and store them. Then take then to list view for advanced degree selection and later allow them to select course from advanced degree. This is done using multiple activities and fragments.

# Concepts
Use some basic UI widgets <br>
Use Intents to call other Activities<br>
Handling the Keyboard<br>
Using Fragments<br>
Permanent storage<br>

# Personal Information Activity
The first or main activity collects the basic information about a person. This activity’s view will look like a basic form. The information we will collect is:<br>
First (given) name<br>
Family (last) name<br>
Age<br>
Email<br>
Phone<br>
Major<br>
For each of the first five items (first name, last name, age, email and phone) used a text field to allow the user to enter the data. In each text field the appropriate keyboard needs to be used. The keyboard should not hide the text field the user is entering. All items need a label indicating what information they contain (first name, last name, etc). All items are on a separate line.<br>
To select a major the user needs to go to a second activity.<br>
Finally there is a done button. When the done button is pressed the user information is saved. When the app is killed and restarted the saved data is displayed in this activity.
# Major Selection
To select a major the user is shown a second activity. When this activity is shown the user sees a list of advanced degrees offered by SDSU. The list is given below. The list is shown using a list fragment. When the user selects one of the advanced degrees, say Masters of Science, they are then shown a list of all the majors in that advanced degree. The list for each advanced degree is given below. The user can select a major in that list. When they are done selecting the major bring them back to the Personal Information Activity, with the selected major shown.<br>
For example MS Computer Science or Ph.D. Biology. When the user selects an advanced degree type, say Master of Arts, they may not see the major they are looking for. So they will want to go back to the list of advanced degree type to try again. The user needs to be able to cancel the selection of a major.

# SDSU Advanced Degrees
Doctor of Philosophy (Ph.D.)<br>
Doctor of Education (Ed.D.)<br>
Master of Arts (MA)<br>
Master of Science (MS)<br>
Master of Fine Arts (MFA)<br>

# Professional Master's Degrees
# Doctor of Philosophy (Ph.D.)
Bioengineering<br>
Biology<br>
Chemistry<br>
Clinical Psychology<br>
Computational Science<br>
Ecology<br>
Education<br>
Engineering/Bioengineering<br>
Engineering/Electrical and Computer<br>
Engineering/Mechanical and Aerospace<br>
Engineering/Structural<br>
Evolutionary Biology<br>
Geography<br>
Geophysics<br>
Language and Communicative Disorders<br>
Mathematics and Science Education<br>
Public Health<br>
# Doctor of Education (Ed.D.)
Educational Leadership/Pre K-12<br>
Educational Leadership/Post Secondary Community College<br>
# Master of Arts (MA)
Anthropology<br>
Art<br>
Biology<br>
Chemistry<br>
Chicana and Chicano Studies<br>
Communication<br>
Speech, Language and Hearing Sciences<br>
Economics<br>
Education<br>
English<br>
French<br>
Geography<br>
History<br>
Interdisciplinary Studies<br>
Journalism and Media Studies<br>
Latin American Studies<br>
Liberal Arts and Sciences<br>
Linguistics<br>
Mathematics<br>
Music<br>
Philosophy<br>
Physics<br>
Political Science<br>
Psychology<br>
Rhetoric and Writing Studies<br>
Sociology<br>
Spanish<br>
Television, Film and New Media Production<br>
Theatre Arts<br>
Women's Studies<br>
# Master of Science (MS)
Accountancy<br>
Aerospace Engineering<br>
Applied Mathematics<br>
Astronomy<br>
Bioengineering<br>
Biology<br>
Bioinformatics and Medical Informatics<br>
Biomedical Quality Systems<br>
Business Administration<br>
Chemistry<br>
Child Development<br>
Civil Engineering<br>
Computational Science<br>
Computer Science<br>
Counseling<br>
Criminal Justice and Criminology<br>
Electrical Engineering<br>
Exercise Physiology<br>
Geography<br>
Geological Sciences<br>
Gerontology<br>
Homeland Security<br>
Hospitality and Tourism Management<br>
Information Systems<br>
Interdisciplinary Studies<br>
Kinesiology<br>
Mechanical Engineering<br>
Medical Physics<br>
Microbiology<br>
Nursing<br>
Nutritional Sciences<br>
Physics<br>
Psychology<br>
Public Health<br>
Regulatory Affairs<br>
Rehabilitation Counseling<br>
Statistics<br>
# Master of Fine Arts (MFA)
Art<br>
Creative Writing<br>
Design and Technical Theatre<br>
Musical Theatre<br>
Theatre Arts<br>
