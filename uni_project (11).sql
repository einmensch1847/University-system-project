-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2024 at 05:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uni_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `about_the_university`
--

CREATE TABLE `about_the_university` (
  `text` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `about_the_university`
--

INSERT INTO `about_the_university` (`text`, `id`) VALUES
('RWTH Aachen University (German: [ˌɛʁveːteːˌhaː ˈʔaːxn̩]), in German Rheinisch-Westfälische Technische Hochschule Aachen,[a] is a German public research university located in Aachen, North Rhine-Westphalia, Germany. With more than 47,000 students enrolled in 144 study programs, it is the largest technical university in Germany.\n\nRWTH Aachen in 2019 emerged from the final of the third federal and state excellence strategy. The university will be funded as a university of excellence for the next seven years. RWTH Aachen was already part of the federal and state excellence initiative in 2007 and 2012.\n\nSince 2007, RWTH Aachen has been continuously funded by the DFG and the German Council of Science and Humanities as one of eleven (previously nine) German Universities of Excellence for its future concept RWTH 2020: Meeting Global Challenges and the follow-up concept The Integrated Interdisciplinary University of Science and Technology: Knowledge, Impact, Networks, also receiving grants for associated graduate schools and clusters of excellence.[6] The university regularly accounts for the highest amount of third-party funds among all German universities, placing first per faculty member and second overall in the most recent survey from 2018.[7]\n\nRWTH Aachen is a founding member of the CESAER association of universities of science and technology in Europe, and IDEA League, a strategic alliance of five leading universities of technology in Europe,[8] as well as its German counterpart TU9. It is also a member of DFG and the Top Industrial Managers for Europe network..\n\nHistory\nOn 25 January 1858, prince Frederick William of Prussia (later German emperor), was given a donation of 5,000 talers from the Aachener und Münchener Feuer-Versicherungs-Gesellschaft, the precursor of the AachenMünchener insurance company, for charity. In March, the prince chose to use the donation to found the first Prussian institute of technology somewhere in the Rhine province. The seat of the institution remained undecided over years; while the prince initially favored Koblenz, the cities of Aachen, Bonn, Cologne and Düsseldorf also applied, with Aachen and Cologne being the main competitors. Aachen finally won with a financing concept backed by the insurance company and by local banks.[9] Groundbreaking for the new Polytechnikum took place on 15 May 1865 and lectures started during the Franco-Prussian War on 10 October 1870 with 223 students and 32 teachers. The new institution had as its primary purpose the education of engineers, especially for the mining industry in the Ruhr area; there were schools of chemistry, electrical and mechanical engineering as well as an introductory general school that taught mathematics and natural sciences and some social sciences.\n\n\nMain Building of the RWTH Aachen. It was built in 1870.\nThe unclear position of the new Prussian polytechnika (which officially were not universities) affected the first years. Polytechnics lacked prestige in society and the number of students decreased. This began to change in 1880 when the early RWTH, amongst others, was reorganized as a Royal Technical University, gained a seat in the Prussian House of Lords and finally won the right to bestow Dr.-Ing. (1899) degrees and Dipl.-Ing. titles (introduced in 1902). In the same year, over 800 male students enrolled. In 1909 the first women were admitted and the artist August von Brandis succeeded Alexander Frenz at the Faculty of Architecture as a \"professor of figure and landscape painting\", Brandis became dean in 1929.[10]\n\nWorld War I, however, proved a serious setback for the university. Many students voluntarily joined up and died in the war, and parts of the university were shortly occupied or confiscated.\n\nWhile the (then no more royal) TH Aachen (Technische Hochschule Aachen) flourished in the 1920s with the introduction of more independent faculties, of several new institutes and of the general students\' committee, the first signs of nationalist radicalization also became visible within the university. Nazi Germany\'s Gleichschaltung of the TH in 1933 met with relatively low resistance from both students and faculty. Beginning in September 1933, Jewish and (alleged) Communist professors (and from 1937 on also students) were systematically persecuted and excluded from the university. Vacant Chairs were increasingly given to NSDAP party-members or sympathizers.[11] The freedom of research and teaching became severely limited, and institutes important for the regime\'s plans were systematically established, and existing chairs promoted. Briefly closed in 1939, the TH continued courses in 1940, although with a low number of students. On 21 October 1944, when Aachen capitulated, more than 70% of all buildings of the university were destroyed or heavily damaged.\n\nAfter World War II ended in 1945 the university recovered and expanded quickly. In the 1950s, many professors who had been removed because of their alleged affiliation with the Nazi party were allowed to return and a multitude of new institutes were founded. By the late 1960s, the TH had 10,000 students, making it the foremost of all German technical universities. With the foundation of philosophical and medical faculties in 1965 and 1966, respectively, the university became more \"universal\". The newly founded faculties in particular began attracting new students, and the number of students almost doubled twice from 1970 (10,000) to 1980 (more than 25,000) and from 1980 to 1990 (more than 37,000).[12] Now, the average number of students is around 42,000, with about one third of all students being women. By relative terms, the most popular study-programs are engineering (57%), natural science (23%), economics and humanities (13%) and medicine (7%).[12]\n\nRecent developments\n\n\"Red lecture hall\" at the central campus\nIn December 2006, RWTH Aachen and the Sultanate of Oman signed an agreement to establish a private German University of Technology in Muscat. Professors from Aachen aided in developing the curricula for the currently five study-programs and scientific staff took over some of the first courses.[13]\n\nIn 2007, RWTH Aachen was chosen as one of nine German Universities of Excellence for its future concept RWTH 2020: Meeting Global Challenges, earning it the connotation of being a \"University of Excellence\". However, although the list of universities honored for their future concepts mostly consists of large and already respected institutions, the Federal Ministry of Education and Research claimed that the initiative aimed at promoting universities with a dedicated future concept so they could continue researching on an international level.[14] Having won funds in all three lines of funding, the process brought RWTH Aachen University an additional total funding of €180 million from 2007 to 2011. The other two lines of funding were graduate schools, where the Aachen Institute for Advanced Study in Computational Engineering Science received funding and so-called \"clusters of excellence\", where RWTH Aachen managed to win funding for the three clusters: Ultra High-Speed Mobile Information and Communication (UMIC), Integrative Production Technology for High-wage Countries and Tailor-Made Fuels from Biomass (TMFB).[15]\n\nRWTH was selected to receive funding from the German federal and state governments for the third Universities of Excellence funding line starting 2019. RWTH\'s proposal was called \"The Integrated Interdisciplinary University of Science and Technology – Knowledge. Impact. Networks.\" and has secured funding for a seven-year period.\n\n2019 Clusters of Excellence\n\nThe Fuel Science Center (FSC) Adaptive Conversion Systems for Renewable Energy and Carbon Sources\nInternet of Production\nML4Q – Matter and Light for Quantum Computing\nRWTH was already awarded funding in the first and second Universities of Excellence funding lines, in 2007 and 2012 respectively.\n\nRWTH Aachen University\'s 620 acres (250 ha) campus is located in the north-western part of the city Aachen. There are two core areas – midtown and Melaten district. The Main Building, SuperC student\'s center and the Kármán Hall are 500 m away from the city centre with the Aachen Cathedral, the Audimax (biggest lecture hall) and the main refectory are 200 m farther. Other points of interest include the university\'s botanical garden (Botanischer Garten Aachen).\n\nA new building, the so-called Central Auditorium for Research and Learning (CARL) was opened in 2017. It offers space for 4000 students and replaces Audimax as the largest lecture hall building. The name of the new central auditorium, which is going to contain different lecture halls, is a reference to Charlemagne, who reigned his empire from Aachen in the middle-ages.[16][17]\n\nThe RWTH has external facilities in Jülich and Essen and owns, together with the University of Stuttgart, a house in Kleinwalsertal in the Austrian Alps.\n\nThe university is currently expanding in the city center and Melaten district. The SuperC, the new central service building for students, was opened in 2008. The groundbreaking for the new Campus-Melaten was in 2009\n', 0),
('RWTH Aachen University (German: [ˌɛʁveːteːˌhaː ˈʔaːxn̩]), in German Rheinisch-Westfälische Technische Hochschule Aachen,[a] is a German public research university located in Aachen, North Rhine-Westphalia, Germany. With more than 47,000 students enrolled in 144 study programs, it is the largest technical university in Germany.\n\nRWTH Aachen in 2019 emerged from the final of the third federal and state excellence strategy. The university will be funded as a university of excellence for the next seven years. RWTH Aachen was already part of the federal and state excellence initiative in 2007 and 2012.\n\nSince 2007, RWTH Aachen has been continuously funded by the DFG and the German Council of Science and Humanities as one of eleven (previously nine) German Universities of Excellence for its future concept RWTH 2020: Meeting Global Challenges and the follow-up concept The Integrated Interdisciplinary University of Science and Technology: Knowledge, Impact, Networks, also receiving grants for associated graduate schools and clusters of excellence.[6] The university regularly accounts for the highest amount of third-party funds among all German universities, placing first per faculty member and second overall in the most recent survey from 2018.[7]\n\nRWTH Aachen is a founding member of the CESAER association of universities of science and technology in Europe, and IDEA League, a strategic alliance of five leading universities of technology in Europe,[8] as well as its German counterpart TU9. It is also a member of DFG and the Top Industrial Managers for Europe network..\n\nHistory\nOn 25 January 1858, prince Frederick William of Prussia (later German emperor), was given a donation of 5,000 talers from the Aachener und Münchener Feuer-Versicherungs-Gesellschaft, the precursor of the AachenMünchener insurance company, for charity. In March, the prince chose to use the donation to found the first Prussian institute of technology somewhere in the Rhine province. The seat of the institution remained undecided over years; while the prince initially favored Koblenz, the cities of Aachen, Bonn, Cologne and Düsseldorf also applied, with Aachen and Cologne being the main competitors. Aachen finally won with a financing concept backed by the insurance company and by local banks.[9] Groundbreaking for the new Polytechnikum took place on 15 May 1865 and lectures started during the Franco-Prussian War on 10 October 1870 with 223 students and 32 teachers. The new institution had as its primary purpose the education of engineers, especially for the mining industry in the Ruhr area; there were schools of chemistry, electrical and mechanical engineering as well as an introductory general school that taught mathematics and natural sciences and some social sciences.\n\n\nMain Building of the RWTH Aachen. It was built in 1870.\nThe unclear position of the new Prussian polytechnika (which officially were not universities) affected the first years. Polytechnics lacked prestige in society and the number of students decreased. This began to change in 1880 when the early RWTH, amongst others, was reorganized as a Royal Technical University, gained a seat in the Prussian House of Lords and finally won the right to bestow Dr.-Ing. (1899) degrees and Dipl.-Ing. titles (introduced in 1902). In the same year, over 800 male students enrolled. In 1909 the first women were admitted and the artist August von Brandis succeeded Alexander Frenz at the Faculty of Architecture as a \"professor of figure and landscape painting\", Brandis became dean in 1929.[10]\n\nWorld War I, however, proved a serious setback for the university. Many students voluntarily joined up and died in the war, and parts of the university were shortly occupied or confiscated.\n\nWhile the (then no more royal) TH Aachen (Technische Hochschule Aachen) flourished in the 1920s with the introduction of more independent faculties, of several new institutes and of the general students\' committee, the first signs of nationalist radicalization also became visible within the university. Nazi Germany\'s Gleichschaltung of the TH in 1933 met with relatively low resistance from both students and faculty. Beginning in September 1933, Jewish and (alleged) Communist professors (and from 1937 on also students) were systematically persecuted and excluded from the university. Vacant Chairs were increasingly given to NSDAP party-members or sympathizers.[11] The freedom of research and teaching became severely limited, and institutes important for the regime\'s plans were systematically established, and existing chairs promoted. Briefly closed in 1939, the TH continued courses in 1940, although with a low number of students. On 21 October 1944, when Aachen capitulated, more than 70% of all buildings of the university were destroyed or heavily damaged.\n\nAfter World War II ended in 1945 the university recovered and expanded quickly. In the 1950s, many professors who had been removed because of their alleged affiliation with the Nazi party were allowed to return and a multitude of new institutes were founded. By the late 1960s, the TH had 10,000 students, making it the foremost of all German technical universities. With the foundation of philosophical and medical faculties in 1965 and 1966, respectively, the university became more \"universal\". The newly founded faculties in particular began attracting new students, and the number of students almost doubled twice from 1970 (10,000) to 1980 (more than 25,000) and from 1980 to 1990 (more than 37,000).[12] Now, the average number of students is around 42,000, with about one third of all students being women. By relative terms, the most popular study-programs are engineering (57%), natural science (23%), economics and humanities (13%) and medicine (7%).[12]\n\nRecent developments\n\n\"Red lecture hall\" at the central campus\nIn December 2006, RWTH Aachen and the Sultanate of Oman signed an agreement to establish a private German University of Technology in Muscat. Professors from Aachen aided in developing the curricula for the currently five study-programs and scientific staff took over some of the first courses.[13]\n\nIn 2007, RWTH Aachen was chosen as one of nine German Universities of Excellence for its future concept RWTH 2020: Meeting Global Challenges, earning it the connotation of being a \"University of Excellence\". However, although the list of universities honored for their future concepts mostly consists of large and already respected institutions, the Federal Ministry of Education and Research claimed that the initiative aimed at promoting universities with a dedicated future concept so they could continue researching on an international level.[14] Having won funds in all three lines of funding, the process brought RWTH Aachen University an additional total funding of €180 million from 2007 to 2011. The other two lines of funding were graduate schools, where the Aachen Institute for Advanced Study in Computational Engineering Science received funding and so-called \"clusters of excellence\", where RWTH Aachen managed to win funding for the three clusters: Ultra High-Speed Mobile Information and Communication (UMIC), Integrative Production Technology for High-wage Countries and Tailor-Made Fuels from Biomass (TMFB).[15]\n\nRWTH was selected to receive funding from the German federal and state governments for the third Universities of Excellence funding line starting 2019. RWTH\'s proposal was called \"The Integrated Interdisciplinary University of Science and Technology – Knowledge. Impact. Networks.\" and has secured funding for a seven-year period.\n\n2019 Clusters of Excellence\n\nThe Fuel Science Center (FSC) Adaptive Conversion Systems for Renewable Energy and Carbon Sources\nInternet of Production\nML4Q – Matter and Light for Quantum Computing\nRWTH was already awarded funding in the first and second Universities of Excellence funding lines, in 2007 and 2012 respectively.\n\nRWTH Aachen University\'s 620 acres (250 ha) campus is located in the north-western part of the city Aachen. There are two core areas – midtown and Melaten district. The Main Building, SuperC student\'s center and the Kármán Hall are 500 m away from the city centre with the Aachen Cathedral, the Audimax (biggest lecture hall) and the main refectory are 200 m farther. Other points of interest include the university\'s botanical garden (Botanischer Garten Aachen).\n\nA new building, the so-called Central Auditorium for Research and Learning (CARL) was opened in 2017. It offers space for 4000 students and replaces Audimax as the largest lecture hall building. The name of the new central auditorium, which is going to contain different lecture halls, is a reference to Charlemagne, who reigned his empire from Aachen in the middle-ages.[16][17]\n\nThe RWTH has external facilities in Jülich and Essen and owns, together with the University of Stuttgart, a house in Kleinwalsertal in the Austrian Alps.\n\nThe university is currently expanding in the city center and Melaten district. The SuperC, the new central service building for students, was opened in 2008. The groundbreaking for the new Campus-Melaten was in 2009\n', 0);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `date_of_dirth` text NOT NULL,
  `father_name` text NOT NULL,
  `phone_number` text NOT NULL,
  `postal_code` text NOT NULL,
  `address` text NOT NULL,
  `age` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `id` int(11) NOT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `lastname`, `username`, `password`, `date_of_dirth`, `father_name`, `phone_number`, `postal_code`, `address`, `age`, `date`, `time`, `id`, `salary`) VALUES
('sadra', 'ghofran', 'sa_gh', 'sadra1847ss', '2005-09-03', 'reza', '09144721384.', '123456789', 'tabriz_shahnaz_artnuiversity_sahel market_34', 19, '2024-05-17', '14:46:26', 4, 12),
('Ali', 'Ghofran', 'ali', 'ghofran', '2000-02-27', 'mohammad', '09143456206', '152464369', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 24, '2024-07-02', '12:49:13', 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `admission_request`
--

CREATE TABLE `admission_request` (
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `phone_number` text NOT NULL,
  `Email` text NOT NULL,
  `father_name` text NOT NULL,
  `age` int(11) NOT NULL,
  `nationality` text NOT NULL,
  `country` text NOT NULL,
  `reason` text NOT NULL,
  `other_explanations` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admission_request`
--

INSERT INTO `admission_request` (`name`, `lastname`, `phone_number`, `Email`, `father_name`, `age`, `nationality`, `country`, `reason`, `other_explanations`, `date`, `time`, `id`) VALUES
('1', '1', '1', '1', '1', 1, '1', '1', '1', '1', '2024-05-11', '18:36:40', 1),
('sadra', 'ghofran', '09144721384', 'sadrareza1847@gmail.com', 'reza', 19, 'turk', 'iran', 'ich lebe in der deuthland lerne ', 'ich in ein holzschnizeri', '2024-05-11', '18:39:54', 2),
('sadra', 'ghofran', '09144721384', 'sadrareza1847@gmail.com', 'reza', 19, 'turk', 'iran', 'ich lebe in der deuthland lerne ', 'ich in ein holzschnizeri', '2024-05-11', '18:41:14', 3),
('1', '1', '1', '1', '1', 1, '1', '1', '11', '11', '2024-05-11', '18:43:01', 4);

-- --------------------------------------------------------

--
-- Table structure for table `apply_for_a_student_loan`
--

CREATE TABLE `apply_for_a_student_loan` (
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `email` text NOT NULL,
  `phon_number` text NOT NULL,
  `requested_amount` int(11) NOT NULL,
  `student_number` text NOT NULL,
  `age` int(11) NOT NULL,
  `other_explanations` text NOT NULL,
  `reason` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `apply_for_a_student_loan`
--

INSERT INTO `apply_for_a_student_loan` (`name`, `lastname`, `email`, `phon_number`, `requested_amount`, `student_number`, `age`, `other_explanations`, `reason`, `date`, `time`, `id`) VALUES
('sadra ', 'ghofran', 'sadrareza1847@gmail.com', '09144721384', 2000, '140225362065', 19, 'دانشجوی ترم 2 مهندسی کامپیوتر هستم', 'برای خرید لپتاپ ', '2024-05-15', '17:22:35', 3),
('asra', 'mohebi ', 'asramohebi@gmail.com', '09027277187', 10000, '140223467965', 19, 'ich bruce dich', '...', '2024-05-15', '17:25:51', 4),
('صدرا', 'غفران', 'sagh@gmail.com', '09370468808', 3000, '140214098547', 24, 'دانشجو ترم 6 فیزیک', 'برای پروژه دانشگاهی', '2024-05-15', '17:28:36', 5);

-- --------------------------------------------------------

--
-- Table structure for table `chemistry_lab`
--

CREATE TABLE `chemistry_lab` (
  `reason` text NOT NULL,
  `student_leval` text NOT NULL,
  `name` text NOT NULL,
  `number_of_persons` int(11) NOT NULL,
  `time_reservation` int(11) NOT NULL,
  `student_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chemistry_lab`
--

INSERT INTO `chemistry_lab` (`reason`, `student_leval`, `name`, `number_of_persons`, `time_reservation`, `student_number`) VALUES
('11111111111111111111111111111111111111111111111111111111111111111111111\n11111111111', '1', '1', 1, 1, 1),
('11111111111111111111111111111111111111111111111111111111111111111111111\n11111111111', '1', '1', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `communication_with_the_university`
--

CREATE TABLE `communication_with_the_university` (
  `text` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `communication_with_the_university`
--

INSERT INTO `communication_with_the_university` (`text`, `id`) VALUES
('instagram : \nhttps://www.instagram.com/rwthaachenuniversity/\n\nlinkedin : \nhttps://de.linkedin.com/school/rwth-aachen-university/\n\nyoutube : \nhttps://www.youtube.com/user/RWTHAachenUniversity\n\ntiktok :\nhttps://www.tiktok.com/@rwth_aachen_university\n\nfacebook :\nhttps://de-de.facebook.com/RWTHAachenUniversity\n\ntwitter (X) :\nhttps://twitter.com/RWTH\n\nprogramer imail : \nsadrareza1847@gmail.com', 0),
('instagram : \nhttps://www.instagram.com/rwthaachenuniversity/\n\nlinkedin : \nhttps://de.linkedin.com/school/rwth-aachen-university/\n\nyoutube : \nhttps://www.youtube.com/user/RWTHAachenUniversity\n\ntiktok :\nhttps://www.tiktok.com/@rwth_aachen_university\n\nfacebook :\nhttps://de-de.facebook.com/RWTHAachenUniversity\n\ntwitter (X) :\nhttps://twitter.com/RWTH\n\nprogramer imail : \nsadrareza1847@gmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `critics_and_suggestions`
--

CREATE TABLE `critics_and_suggestions` (
  `Critics_and_suggestions` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `critics_and_suggestions`
--

INSERT INTO `critics_and_suggestions` (`Critics_and_suggestions`, `date`, `time`) VALUES
('jjjjjjjjjjjj', '2024-05-10', ''),
('ddddddddd', '2024-05-10', ''),
('ddddddddd', '2024-05-10', ''),
('jlkjhlhlkjkjkjh', '2024-05-10', '14:19:02'),
('hallo ich bin sadra ghofran and ich comme AUS dem tabrin in dem iran \nich mochte in deuthland universiteten lernen ', '2024-05-10', '14:20:19'),
('fd', '2024-05-10', '14:23:22'),
('ksjdnsandjad', '2024-05-11', '18:19:33'),
('سلام ', '2024-05-17', '14:22:51'),
('hallo ich bin sadra ghofran und ich comme aus dem iran ich mochter in tabriz university\nblaybe , bitte hilfe mir gott ich brauche deine hilfe \n\nsadra ghofran ', '2024-05-31', '20:29:25'),
('jjjjjjjjjjjj', '2024-05-10', ''),
('ddddddddd', '2024-05-10', ''),
('ddddddddd', '2024-05-10', ''),
('jlkjhlhlkjkjkjh', '2024-05-10', '14:19:02'),
('hallo ich bin sadra ghofran and ich comme AUS dem tabrin in dem iran \nich mochte in deuthland universiteten lernen ', '2024-05-10', '14:20:19'),
('fd', '2024-05-10', '14:23:22'),
('ksjdnsandjad', '2024-05-11', '18:19:33'),
('سلام ', '2024-05-17', '14:22:51'),
('hallo ich bin sadra ghofran und ich comme aus dem iran ich mochter in tabriz university\nblaybe , bitte hilfe mir gott ich brauche deine hilfe \n\nsadra ghofran ', '2024-05-31', '20:29:25'),
(',njn,mn,', '2024-06-20', '15:59:00');

-- --------------------------------------------------------

--
-- Table structure for table `education_employee`
--

CREATE TABLE `education_employee` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `phone_number` text NOT NULL,
  `email` text NOT NULL,
  `salary` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `education_employee`
--

INSERT INTO `education_employee` (`id`, `name`, `lastname`, `username`, `password`, `phone_number`, `email`, `salary`, `date`, `time`) VALUES
(3, 'mohsen', 'mohseni', 'mohsen12', '12', '09142346090', 'mohsen13@gmail.com', 15000, '2024-07-03', '00:06:19'),
(4, 'sadaf', 'ghofran', 'sadaf', '12', '09145678430', 'sadaf_gh23@gmail.com', 13000, '2024-07-03', '00:07:22'),
(5, 'sonia', 'ashrafy', 'sa', 'sad', '09142356081', 'sonia13@gmail.com', 20000, '2024-07-03', '00:09:29');

-- --------------------------------------------------------

--
-- Table structure for table `electrical_lab`
--

CREATE TABLE `electrical_lab` (
  `reason` text NOT NULL,
  `student_leval` text NOT NULL,
  `name` text NOT NULL,
  `number_of_persons` int(11) NOT NULL,
  `time_reservation` int(11) NOT NULL,
  `student_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `electrical_lab`
--

INSERT INTO `electrical_lab` (`reason`, `student_leval`, `name`, `number_of_persons`, `time_reservation`, `student_number`) VALUES
('1', '1', '1', 1, 1, 1),
('1', '1', '1', 1, 1, 1),
('1', '1', '1', 1, 1, 1),
('1', '1', '1', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `fille`
--

CREATE TABLE `fille` (
  `name` text NOT NULL,
  `email` text NOT NULL,
  `id` int(11) NOT NULL,
  `file` longblob DEFAULT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `finance_staff`
--

CREATE TABLE `finance_staff` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `phone_number` text NOT NULL,
  `email` text NOT NULL,
  `salary` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finance_staff`
--

INSERT INTO `finance_staff` (`id`, `name`, `lastname`, `username`, `password`, `phone_number`, `email`, `salary`, `date`, `time`) VALUES
(2, 'sadra', 'mohseni', 'sadra', 'sadra', '0914435727', 'adadd@gmail.com', 10000, '2024-07-03', '00:20:58'),
(3, 'mohsen', 'toloye', 'mohsen', 'tol', '09144721384', 'mohsen_toloyee_12@gmail.com', 20000, '2024-07-05', '16:48:40');

-- --------------------------------------------------------

--
-- Table structure for table `international_students`
--

CREATE TABLE `international_students` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `field` text NOT NULL,
  `date_of_dirth` text NOT NULL,
  `father_name` text NOT NULL,
  `phone_number` text NOT NULL,
  `postal_code` text NOT NULL,
  `address` text NOT NULL,
  `tuition` text NOT NULL,
  `age` int(11) NOT NULL,
  `debt` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `unit` int(11) NOT NULL,
  `L1` text NOT NULL,
  `L2` text NOT NULL,
  `L3` text NOT NULL,
  `L4` text NOT NULL,
  `L5` text NOT NULL,
  `L6` text NOT NULL,
  `L7` text NOT NULL,
  `L8` text NOT NULL,
  `L9` text NOT NULL,
  `L10` text NOT NULL,
  `student_number` text NOT NULL,
  `nationality` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `international_students`
--

INSERT INTO `international_students` (`id`, `name`, `lastname`, `username`, `password`, `field`, `date_of_dirth`, `father_name`, `phone_number`, `postal_code`, `address`, `tuition`, `age`, `debt`, `date`, `time`, `unit`, `L1`, `L2`, `L3`, `L4`, `L5`, `L6`, `L7`, `L8`, `L9`, `L10`, `student_number`, `nationality`) VALUES
(1, 'sadra', 'ghofran', 'sasa', 'sasa', 'computer', '2024-05-31', 'ali', '09144721384', '1234567890', '123456789', 'lkjhgfds', 12, 12, '2024-06-11', '17:05:33', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '1363991744', 'irani');

-- --------------------------------------------------------

--
-- Table structure for table `main_page_tabel`
--

CREATE TABLE `main_page_tabel` (
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `main_page_tabel`
--

INSERT INTO `main_page_tabel` (`text`) VALUES
('wllcome to rrwth');

-- --------------------------------------------------------

--
-- Table structure for table `management_employee`
--

CREATE TABLE `management_employee` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `phone_number` text NOT NULL,
  `email` text NOT NULL,
  `salary` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `management_employee`
--

INSERT INTO `management_employee` (`id`, `name`, `lastname`, `username`, `password`, `phone_number`, `email`, `salary`, `date`, `time`) VALUES
(2, 'sama', 'zargar', 'sama', 'sa', '09356785390', 'sama2345d@gmail.com', 12000, '2024-07-03', '00:11:21'),
(3, 'sadra', 'ghofran', 'sa', 'gh', '09142346783', 'sa_gh164@gmail.com', 9000, '2024-07-03', '00:12:12');

-- --------------------------------------------------------

--
-- Table structure for table `management_employees_page_text`
--

CREATE TABLE `management_employees_page_text` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `management_employees_page_text`
--

INSERT INTO `management_employees_page_text` (`id`, `text`) VALUES
(0, 'employees panel \n\nwelcomme to the RWTH ACHEN ');

-- --------------------------------------------------------

--
-- Table structure for table `mathematics_lab`
--

CREATE TABLE `mathematics_lab` (
  `id` int(11) NOT NULL,
  `reason` text NOT NULL,
  `student_leval` text NOT NULL,
  `name` text NOT NULL,
  `time_reservation` int(11) NOT NULL,
  `student_number` int(11) NOT NULL,
  `number_of_persons` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mathematics_lab`
--

INSERT INTO `mathematics_lab` (`id`, `reason`, `student_leval`, `name`, `time_reservation`, `student_number`, `number_of_persons`) VALUES
(1, '...', 'dr', 'sadra ghofran', 12, 123456, 12);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `text`) VALUES
(0, 'Donation Campaign: RWTH and Uniklinik RWTH Aachen Help Ukraine\n\n\nAid Program for Hospitals\n\nRWTH Aachen University and Uniklinik RWTH Aachen are helping the people in war-torn Ukraine. The donations will be used to provide local hospitals with urgently needed medicines, bandages, and other medical supplies.\n\nAndrji Pich, a native of Ukraine and professor at the Institute of Technical and Macromolecular Chemistry at RWTH Aachen University and DWI-Leibniz Institute for Interactive Materials, is the initiator of the aid campaign. He still has family and friends in the country, many of whom work as doctors in Lviv and Kyiv, so he knows what is needed. Above all, bandages, painkillers, and narcotics for operations and serious injuries are urgently needed. The drugstore of Uniklinik RWTH Aachen uses these funds to procure what is urgently needed in the Ukrainian hospitals.\n\nThe campaign team has established a stable logistics chain. The supplies are reloaded into smaller vans at the Polish-Ukrainian border to protect them from attacks, which are often carried out on larger convoys. With the help of Professor Pich and his network, they will be taken right to the hospitals in Ukraine where they are needed to help care for the victims of the war.\n\n\nNext Generation University\n\n\nThe current global ecological, social, economic, and, most recently, geopolitical developments certainly demand the most extraordinary efforts from our knowledge society. The science and innovation system has a special responsibility here.\nWe are convinced that universities have what it takes to help shape the future of our rapidly developing world:\n\nThey research the foundations for key technologies and thus provide the basis for a strong economy that is internationally competitive and for an innovative society that is fit for the future.\nThey provide the future workforce not only with the skills but also with the attitude that they can and must shape the world of tomorrow in the face of a multitude of global challenges.\nThey set the tone for half of a birth cohort (in 2021, the proportion of first-year students in a birth cohort in Germany was 54 percent, comprising a total of 2.89 million students), and they are also key players in the continuing education of skilled workers.\nBy communicating science to the public, they help citizens understand the transformation and encourage them be an active part of it in their daily lives.\nBut in order for the age-old institution university to actually tackle pressing global challenges, it must actively position itself as a player in society. Here and now universities are needed that think strategically and act quickly, that have a contemporary understanding of their role in the knowledge society, and that are closely linked to other research institutions, business, civil society, and politics.\n\nIn recent years, RWTH has therefore repeatedly fostered and promoted an active, transparent dialogue with various stakeholders in the scientific landscape in order to work together towards an impact-oriented science and innovation system that best serves our society. The goal of these efforts is a \"Next Generation University\". One recognizable starting point for the networking and exchange formats to date was an international science evening to which RWTH invited the scientific community to Berlin in 2021. This evening was held to mark the University\'s 150th anniversary.\n\nCONTACT\nNAME\nCharlotte Tuschinski\n\nPHONE\nwork+49 241 80-93891\n\n\nVolcanic Eruptions? Beautiful!\n\n\nIn Iceland, the ground is cracking open; in the Phlegraean Fields near Naples, it is rumbling violently – the ground is in motion. Professor Klaus Reicherter is head of the Neotectonics and Natural Hazards Teaching and Research Unit at RWTH Aachen University. The ground moves here, and the ground moves there, he says, and, in this interview, he explains why it rumbles mightily in the process.\n\nDoes it only seem that way, or is there much more movement on the Earth’s surface right now?\n\nProfessor Klaus Reicherter: It only seems that way. The Earth’s surface is constantly in motion, and there are always earthquakes and volcanic eruptions – there’s nothing special about that. Our perception is influenced by the media because while an earthquake is usually more of a catastrophe with deaths and injuries, a volcanic eruption is beautiful. You can see this flowing, glowing rock, which is really pretty.\n\nThe impending eruption in Iceland and the intense activity in the Phlegraean Fields – is that normal?\n\nYes, that’s normal. I was in Campi Flegrei four weeks ago and got to experience the strongest earthquake with a magnitude of 4.2. Volcanic quakes are quite different from earthquakes that have tectonic causes, i.e., are triggered by faults. Volcanic quakes are more like a tremor and can be permanently measured at active volcanoes. Of course, we observe and analyze them very well, but these quakes have always occurred there; the Earth’s crust is always moving. The catastrophic eruption of Mount Vesuvius in the south of Italy, which destroyed Pompeii in 79 AD, also happened in the Phlegraean Fields. In 1538, the eruption of Montenuovo produced a small cinder cone in the Solfatara – this is similar to what we have and expect here in the West Eifel. What we are now observing in Iceland, La Palma, and the Phlegraean Fields – the three most recent major events in Europe – is the rise of fluids such as magma. These fluids move upwards through the Earth’s crust, creating small quakes that can be tracked. It’s just like the bubbles in sparkling water; you could also say it causes small tremors when they burst. These kinds of earthquakes in the Earth’s crust have recently occurred at shallower depths at the mentioned locations. The quakes allow us to determine the volume of the magma chambers fairly accurately, which is not really a lot in either La Palma or Iceland. So, we are not expecting inexhaustible volcanism that will last for decades, but rather two or three months until the reservoir is empty.\n\nSo, we are not talking about an imminent event but about regularly occurring activity?\n\nExactly. These are recurring events. Sometimes with more – sometimes with a little less volume, even the location can change a little, but the Solfatara is a volcanic area, La Palma is a volcanic island, Iceland is a volcanic island – the events are already concentrated there. We’re not talking about a volcano erupting in Aachen any time soon.\n\nAre the current high levels of activity in Italy and Iceland somehow connected?\n\nNo. These are entirely different systems. The Mid-Atlantic Ridge runs right through Iceland, where the North American and Eurasian plates are drifting apart, which means new material is being formed there, hence the volcanism. Under the Tyrrhenian Sea and the Apennines in Italy, the Adriatic Plate is being subducted, i.e., it is being drawn into the Earth’s mantle. The plate submerges and produces this melting and volcanism – we are familiar with Etna, Stromboli, or Vesuvius there. Sometimes, seafloor spreading creates new crust, and at other times, the plate melts back into the Earth’s mantle. The two forces roughly balance each other. Otherwise, our planet would have to get bigger or smaller, but the plate tectonics of the Earth’s circumference is constant. Whatever is newly formed has to go somewhere.\n\nDoes that mean that some of the Earth’s surface disappears in certain places?\n\nYes, some of the Earth’s surface is disappearing; entire islands are disappearing, for example. This happens all around the Pacific. Take the Andes, for example - subduction certainly occurs there. Other examples are the northern part of the Cascades with Mount St. Helens, then up Canada’s coast, the Aleutian Islands, Kamchatka in Russia, Japan, of course; everywhere along this Pacific “Ring of Fire” land is swallowed up, subducted.\n\nAnd new land is being formed in Iceland.\n\nExactly. There, the plates are pulled apart, and the Earth’s mantle comes to the surface, forming new land that pushes the plates apart.\n\nSounds unspectacular...\n\nAnd it is unspectacular - as far as plate tectonics go. But of course, it is still an eruption – with lava flows and everything that goes with it – certainly something worth seeing.\n\nBack to Italy: The Phlegraean Fields are also known as a supervolcano – is that a scientific term?\n\nSupervolcanoes are huge volcanoes that can actually lead to massive explosions. Vesuvius and Etna are small volcanoes, as are the volcanoes in the Massif Central or the West Eifel; these volcanoes produce less than one cubic kilometer of material. Therefore, as mentioned above, an eruption is over after a relatively short time. The supervolcanoes, on the other hand, need a little more fire from below; they produce tens or hundreds of thousands of times as much. The best known is probably Yellowstone in the USA, with a caldera, a volcanic caldera over 80 kilometers in diameter. Over such a vast area, it erupts here and there in different places. If a supervolcano were to erupt, it would have a significant impact on the climate, as the ash clouds would block out the sun. Since we have not yet been able to get a grip on global warming, some scientists are now working on geoengineering an artificial or provoked volcanic eruption that would release gases into the atmosphere – that’s spooky.\n\nIs a super eruption imminent?\n\nNo. We are monitoring this very well; there is currently no threat of a supervolcano erupting. But we must not take things too lightly either. If the situation worsens in the Phlegraean Fields, three million people must be evacuated.\n\nAs a scientist, how do you look at such natural phenomena? With fascination, with fear?\n\nI fear earthquakes because they are always associated with many victims, especially in poorer areas with poorly constructed buildings. I look at volcanoes differently – as long as there are no victims, of course. That’s spectacular, it’s nice, not horrible. A volcanic eruption is beautiful to behold; it’s practically a tourist magnet and hotspot. I know many people who have traveled to Iceland only to experience real flowing lava. It is awe-inspiring.\n');

-- --------------------------------------------------------

--
-- Table structure for table `physics_lab`
--

CREATE TABLE `physics_lab` (
  `id` int(11) NOT NULL,
  `reason` text NOT NULL,
  `student_leval` text NOT NULL,
  `name` text NOT NULL,
  `number_of_persons` int(11) NOT NULL,
  `time_reservation` int(11) NOT NULL,
  `student_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `password` text NOT NULL,
  `username` text NOT NULL,
  `date_of_dirth` text NOT NULL,
  `age` int(11) NOT NULL,
  `phone_number` text NOT NULL,
  `email` text NOT NULL,
  `address` text NOT NULL,
  `degree_of_education` text NOT NULL,
  `topic` text NOT NULL,
  `unit` int(11) NOT NULL,
  `basic_salary` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `number_of_students` int(11) NOT NULL,
  `overtime` int(11) NOT NULL,
  `subject` text NOT NULL,
  `student_limit` int(11) NOT NULL,
  `OverTimeSalary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`id`, `name`, `lastname`, `password`, `username`, `date_of_dirth`, `age`, `phone_number`, `email`, `address`, `degree_of_education`, `topic`, `unit`, `basic_salary`, `date`, `time`, `number_of_students`, `overtime`, `subject`, `student_limit`, `OverTimeSalary`) VALUES
(3, 'javad', 'maleki', 'pp', 'pp', '1950-07-21', 74, '09144721384', 'javad_maleki12@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'DR of mathematic', 'mathematic', 4, 16000, '2024-07-02', '13:58:11', 5, 0, 'math', 30, 40),
(4, 'sadra', 'ghofran', 'ghofran', 'sadra', '2005-09-03', 19, '09370468808', 'sadrareza1847@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'Dr of computer', 'programing', 4, 20000, '2024-07-02', '13:59:50', 3, 0, '.....', 40, 40),
(5, 'mina', 'zolfi', 'zolfi', 'mina', '1980-08-02', 44, '09876467888', 'mina_zolfi23@gmail.com', 'tehran_emam_sina_21_45', 'physic', 'physic', 2, 50000, '2024-07-02', '14:02:07', 3, 10, '.....', 39, 4000),
(6, 'jafar', 'tanha', 'tt', 'tt', '1987-07-24', 46, '09357688857', 'asjrheoini@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'Dr', 'programing', 3, 20000, '2024-07-02', '23:40:17', 3, 0, '.....', 60, 40),
(7, 'mohammad reza', 'jodary', '123456789', '123456789', '1940-11-06', 80, '09146578851', 'mohammad123456789@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'professor', 'digital', 2, 17000, '2024-07-02', '23:42:39', 3, 0, '.....', 39, 40),
(8, 'mohsen', 'vali', '1234567890', '1234567890', '1940-11-06', 80, '09146578851', 'mohammad123456789@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'professor', 'digital', 2, 17000, '2024-07-02', '23:43:06', 3, 0, '.....', 80, 40),
(9, 'sina', 'mohseni', '123', '123', '1940-11-06', 80, '09146578851', 'mohammad123456789@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'professor', 'digital', 2, 17000, '2024-07-02', '23:43:32', 3, 0, '.....', 50, 40),
(10, 'sohail', 'sazande', '123456789', 'sohail', '1992-12-01', 32, '09146784563', 'sohailmo023@gmail.com', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'DR', 'physic', 1, 14000, '2024-07-03', '00:04:04', 3, 0, '.....', 20, 40);

-- --------------------------------------------------------

--
-- Table structure for table `professors_comments`
--

CREATE TABLE `professors_comments` (
  `id` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `phone_number` text NOT NULL,
  `email` text NOT NULL,
  `text` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professors_comments`
--

INSERT INTO `professors_comments` (`id`, `professor_id`, `name`, `lastname`, `username`, `password`, `phone_number`, `email`, `text`, `date`, `time`) VALUES
(1, 1, '1', '1', '1.', '1', '1', '1', 'jlkjhljh', '2024-06-06', '14:31:41');

-- --------------------------------------------------------

--
-- Table structure for table `professors_dormitory_reqest`
--

CREATE TABLE `professors_dormitory_reqest` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `phone_number` text NOT NULL,
  `Email` text NOT NULL,
  `father_name` text NOT NULL,
  `age` int(11) NOT NULL,
  `reason` text NOT NULL,
  `other_explanations` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professors_dormitory_reqest`
--

INSERT INTO `professors_dormitory_reqest` (`id`, `name`, `lastname`, `phone_number`, `Email`, `father_name`, `age`, `reason`, `other_explanations`, `date`, `time`) VALUES
(1, '1', '1', '1', '1', '1', 1, '1', '1', '2024-06-06', '16:28:01'),
(2, 'sadra', 'ghofran', '09144721384', 'sadrareza1847@gmail.com', 'reza', 19, 'ich mochte ein gute computer verkaufe', 'ich bin ein computer student', '2024-06-11', '15:32:36');

-- --------------------------------------------------------

--
-- Table structure for table `professors_loan_application`
--

CREATE TABLE `professors_loan_application` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `email` text NOT NULL,
  `phon_number` text NOT NULL,
  `requested_amount` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `other_explanations` text NOT NULL,
  `reason` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professors_loan_application`
--

INSERT INTO `professors_loan_application` (`id`, `name`, `lastname`, `email`, `phon_number`, `requested_amount`, `professor_id`, `age`, `other_explanations`, `reason`, `date`, `time`) VALUES
(1, '1', '1', '1', '1', 1, 1, 1, '1', '1', '2024-06-06', '14:32:09');

-- --------------------------------------------------------

--
-- Table structure for table `professors_page_text`
--

CREATE TABLE `professors_page_text` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professors_page_text`
--

INSERT INTO `professors_page_text` (`id`, `text`) VALUES
(0, 'professor panel \n\nwelcomme to the RWTH ACHEN \n\n......\n');

-- --------------------------------------------------------

--
-- Table structure for table `public_chat`
--

CREATE TABLE `public_chat` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `color` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `public_chat`
--

INSERT INTO `public_chat` (`id`, `text`, `date`, `time`, `color`) VALUES
(84, 'salam', '2024-07-02', '13:50:20', 'GREEN'),
(85, 'سلام', '2024-07-02', '13:50:26', 'GREEN'),
(86, 'پروژه برنامه نویسی', '2024-07-02', '13:50:49', 'GREEN'),
(87, 'hallo', '2024-07-02', '23:52:11', 'RED'),
(88, 'gfkgfhg', '2024-07-05', '14:31:01', 'GOLD'),
(89, 'hi ', '2024-07-05', '18:34:04', 'BLUE');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `password` text NOT NULL,
  `username` text NOT NULL,
  `field` text NOT NULL,
  `date_of_dirth` text NOT NULL,
  `father_name` text NOT NULL,
  `phone_number` text NOT NULL,
  `postal_code` text NOT NULL,
  `address` text NOT NULL,
  `tuition` text NOT NULL,
  `age` int(11) NOT NULL,
  `debt` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `unit` int(11) NOT NULL,
  `L1` text NOT NULL,
  `L2` text NOT NULL,
  `L3` text NOT NULL,
  `L4` text NOT NULL,
  `L5` text NOT NULL,
  `L6` text NOT NULL,
  `L7` text NOT NULL,
  `L8` text NOT NULL,
  `L9` text NOT NULL,
  `L10` text NOT NULL,
  `student_number` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `lastname`, `password`, `username`, `field`, `date_of_dirth`, `father_name`, `phone_number`, `postal_code`, `address`, `tuition`, `age`, `debt`, `date`, `time`, `unit`, `L1`, `L2`, `L3`, `L4`, `L5`, `L6`, `L7`, `L8`, `L9`, `L10`, `student_number`) VALUES
(3, 'sadra', 'ghofran', '1363991744', 'sadra_gh', 'mathematic', '...', 'reza', '09144721384', '...', '...', '...', 19, 0, '2024-05-23', '...', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '...'),
(4, '1', '1', '1', '1', '1', '2024-06-12', '1', '1', '1', '1', '1', 1, 15, '2024-06-06', '18:16:18', 0, '3 : Selected \njavad  maleki \\\\\\ .....', '4 : Selected \nsadra  ghofran \\\\\\ .....', '5 : Selected \nmina  zolfi \\\\\\ .....', '6 : Selected \njafar  tanha \\\\\\ .....', '7 : Selected \nmohammad reza  jodary \\\\\\ .....', '8 : Selected \nmohsen  vali \\\\\\ .....', '9 : Selected \nsina  mohseni \\\\\\ .....', '10 : Selected \nsohail  sazande \\\\\\ .....', '...', '...', '1'),
(5, 'mohammad reza', 'salatin', 'salatin', 'mohammad reza', 'electronic', '2004-07-28', 'sina', '0937564482', '1483625945', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'false', 20, 0, '2024-07-02', '12:52:45', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '140224586743'),
(6, 'mina', 'zand', 'zand', 'mina', 'mathematic', '1997-11-08', 'ali', '09387658808', '3216484334', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'false', 27, 0, '2024-07-02', '13:19:10', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '140037645286'),
(7, 'mobina', 'mohammady', 'mohammady', 'mobian', 'chemistry', '1987-07-31', 'sohail', '09142356754', '1298054322', 'tabriz_valiasr_super jordan_Plaque : 34 و Floor : 4', 'true', 37, 2000, '2024-07-02', '13:22:43', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '13993746372'),
(8, 'mohsen', 'rizabadi', 'mm', 'mm', 'phizic', '2003-09-05', 'sina', '09144031341', '1345678644', 'tehran_valiasr_super jordan_Plaque : 30 و Floor : 1', 'false', 19, 0, '2024-07-02', '13:33:37', 0, '...', '...', '...', '...', '...', '...', '...', '...', '...', '...', '139945724964');

-- --------------------------------------------------------

--
-- Table structure for table `student_dormitory_request`
--

CREATE TABLE `student_dormitory_request` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `lastname` text NOT NULL,
  `phone_number` text NOT NULL,
  `Email` text NOT NULL,
  `father_name` text NOT NULL,
  `age` int(11) NOT NULL,
  `reason` text NOT NULL,
  `other_explanations` text NOT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_dormitory_request`
--

INSERT INTO `student_dormitory_request` (`id`, `name`, `lastname`, `phone_number`, `Email`, `father_name`, `age`, `reason`, `other_explanations`, `date`, `time`) VALUES
(1, 'sadra', 'ghofran', '09144721384', 'sadrareza1847@gmail.com', 'reza', 19, '....', '....', '2024-06-11', '12:37:43');

-- --------------------------------------------------------

--
-- Table structure for table `student_fille`
--

CREATE TABLE `student_fille` (
  `name` text NOT NULL,
  `phone_number` text NOT NULL,
  `file` longblob DEFAULT NULL,
  `date` date NOT NULL,
  `time` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student_panel_text`
--

CREATE TABLE `student_panel_text` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_panel_text`
--

INSERT INTO `student_panel_text` (`id`, `text`) VALUES
(0, 'student panel\n\nwellcomme to the RWTH ACHEN'),
(0, 'student panel\n\nwellcomme to the RWTH ACHEN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `password` (`password`) USING HASH;
ALTER TABLE `admin` ADD FULLTEXT KEY `lastname` (`lastname`);

--
-- Indexes for table `admission_request`
--
ALTER TABLE `admission_request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `apply_for_a_student_loan`
--
ALTER TABLE `apply_for_a_student_loan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `education_employee`
--
ALTER TABLE `education_employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- Indexes for table `fille`
--
ALTER TABLE `fille`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `finance_staff`
--
ALTER TABLE `finance_staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- Indexes for table `international_students`
--
ALTER TABLE `international_students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_number` (`student_number`) USING HASH,
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- Indexes for table `management_employee`
--
ALTER TABLE `management_employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- Indexes for table `mathematics_lab`
--
ALTER TABLE `mathematics_lab`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `physics_lab`
--
ALTER TABLE `physics_lab`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH;

--
-- Indexes for table `professors_comments`
--
ALTER TABLE `professors_comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professors_dormitory_reqest`
--
ALTER TABLE `professors_dormitory_reqest`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professors_loan_application`
--
ALTER TABLE `professors_loan_application`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `public_chat`
--
ALTER TABLE `public_chat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING HASH,
  ADD UNIQUE KEY `student_number` (`student_number`) USING HASH;

--
-- Indexes for table `student_dormitory_request`
--
ALTER TABLE `student_dormitory_request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_fille`
--
ALTER TABLE `student_fille`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `admission_request`
--
ALTER TABLE `admission_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `apply_for_a_student_loan`
--
ALTER TABLE `apply_for_a_student_loan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `education_employee`
--
ALTER TABLE `education_employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `fille`
--
ALTER TABLE `fille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `finance_staff`
--
ALTER TABLE `finance_staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `international_students`
--
ALTER TABLE `international_students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `management_employee`
--
ALTER TABLE `management_employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `mathematics_lab`
--
ALTER TABLE `mathematics_lab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `physics_lab`
--
ALTER TABLE `physics_lab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `professors_comments`
--
ALTER TABLE `professors_comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `professors_dormitory_reqest`
--
ALTER TABLE `professors_dormitory_reqest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `professors_loan_application`
--
ALTER TABLE `professors_loan_application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `public_chat`
--
ALTER TABLE `public_chat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student_dormitory_request`
--
ALTER TABLE `student_dormitory_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student_fille`
--
ALTER TABLE `student_fille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
