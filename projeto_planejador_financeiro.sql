-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 20-Jun-2023 às 22:07
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto_planejador_financeiro`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nome`) VALUES
(2, 'Teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `despesa`
--

CREATE TABLE `despesa` (
  `id_despesa` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `despesa`
--

INSERT INTO `despesa` (`id_despesa`, `nome`, `codigo_categoria`, `data`, `frequencia`, `valor`) VALUES
(3, 'Teste', 2, '2023-06-19 22:30:00', 0, 1200);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fundo_ocasional`
--

CREATE TABLE `fundo_ocasional` (
  `id_fundo_ocasional` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `investimento`
--

CREATE TABLE `investimento` (
  `id_investimento` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rendimento`
--

CREATE TABLE `rendimento` (
  `id_rendimento` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `frequencia` int(11) NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Índices para tabela `despesa`
--
ALTER TABLE `despesa`
  ADD PRIMARY KEY (`id_despesa`),
  ADD KEY `fk_codigo_categoria` (`id_despesa`);

--
-- Índices para tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  ADD PRIMARY KEY (`id_fundo_ocasional`);

--
-- Índices para tabela `investimento`
--
ALTER TABLE `investimento`
  ADD PRIMARY KEY (`id_investimento`);

--
-- Índices para tabela `rendimento`
--
ALTER TABLE `rendimento`
  ADD PRIMARY KEY (`id_rendimento`),
  ADD KEY `fk_codigo_categoria` (`codigo_categoria`) USING BTREE;

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `despesa`
--
ALTER TABLE `despesa`
  MODIFY `id_despesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `fundo_ocasional`
--
ALTER TABLE `fundo_ocasional`
  MODIFY `id_fundo_ocasional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `investimento`
--
ALTER TABLE `investimento`
  MODIFY `id_investimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `rendimento`
--
ALTER TABLE `rendimento`
  MODIFY `id_rendimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
