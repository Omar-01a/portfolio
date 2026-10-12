function Hero() {
  return (
    <section
      id="home"
      className="relative flex min-h-screen items-center justify-center overflow-hidden px-6 pt-20"
    >

      {/* Background Glow */}
      <div className="absolute left-1/2 top-1/2 -z-10 h-96 w-96 -translate-x-1/2 -translate-y-1/2 rounded-full bg-blue-500/10 blur-3xl" />

      <div className="max-w-4xl text-center">

        {/* Small title */}
        <p className="mb-5 text-sm font-medium uppercase tracking-[0.35em] text-gray-500">
         Software Engineer
        </p>


        {/* Main heading */}
        <h1 className="text-5xl font-bold leading-tight tracking-tight md:text-7xl">

          Building modern

          <br />

          <span className="text-gray-400">
            backend systems.
          </span>

        </h1>


        {/* Description */}
        <p className="mx-auto mt-8 max-w-2xl text-lg leading-8 text-gray-400 md:text-xl">
          I'm Omar Alabdullatif, a Computer Science graduate focused on
          building reliable backend applications using Java, Spring Boot
          and PostgreSQL.
        </p>


        {/* Technologies */}
        <p className="mt-6 text-sm text-gray-500">
          <span className="mx-2">•</span>Java <span className="mx-2">•</span>
          Spring Boot <span className="mx-2">•</span>
          PostgreSQL <span className="mx-2">•</span>
          Cloud<span className="mx-2">•</span>
          AI 
        </p>


        {/* Buttons */}
        <div className="mt-10 flex flex-col justify-center gap-4 sm:flex-row">

          <a
            href="#projects"
            className="rounded-lg bg-white px-7 py-3 font-medium text-black transition hover:-translate-y-0.5 hover:bg-gray-200"
          >
            View Projects
          </a>

          <a
            href="#contact"
            className="rounded-lg border border-white/20 px-7 py-3 font-medium transition hover:-translate-y-0.5 hover:bg-white/10"
          >
            Contact Me
          </a>

        </div>


        {/* Scroll indicator */}
        <a
          href="#about"
          className="mt-16 inline-block text-sm text-gray-600 transition hover:text-gray-400"
        >
          Scroll to explore ↓
        </a>

      </div>

    </section>
  )
}

export default Hero