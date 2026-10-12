function About() {
  return (
    <section
      id="about"
      className="border-t border-white/10 px-6 py-24 md:py-32"
    >

      <div className="mx-auto max-w-6xl">

        {/* Section Title */}
        <div>
          <p className="mb-3 text-sm font-medium uppercase tracking-[0.35em] text-gray-500">
            About Me
          </p>

          <h2 className="text-4xl font-bold tracking-tight md:text-5xl">
            A little about me.
          </h2>
        </div>


        {/* Content */}
        <div className="mt-14 grid gap-12 md:grid-cols-2 md:items-center">

          {/* Description */}
          <div>

            <p className="text-lg leading-8 text-gray-400">
              Motivated Computer Science graduate with hands-on experience in software development, data analytics, and technical support. 
Proficient in Java (Spring Boot), Python, Flutter, and SQL, with a strong background in developing smart systems using IoT and AI. 
Proven ability to troubleshoot IT issues, optimize workflows, and analyze complex data. Fast learner seeking to leverage software 
engineering and analytical skills in a full-time role.
            </p>

           


            {/* Small Info */}
            <div className="mt-8 flex flex-wrap gap-3">

              <span className="rounded-full border border-white/10 bg-white/[0.03] px-4 py-2 text-sm text-gray-400">
                Computer Science
              </span>

              <span className="rounded-full border border-white/10 bg-white/[0.03] px-4 py-2 text-sm text-gray-400">
                Backend Development
              </span>

              <span className="rounded-full border border-white/10 bg-white/[0.03] px-4 py-2 text-sm text-gray-400">
                Software Engineering
              </span>

            </div>

          </div>


          {/* Technology Cards */}
          <div className="grid grid-cols-2 gap-4">

            <div className="group rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:-translate-y-1 hover:border-white/20 hover:bg-white/[0.05]">
              <h3 className="text-xl font-bold">
                Java
              </h3>

              <p className="mt-2 text-sm text-gray-500">
                Backend Development
              </p>
            </div>


            <div className="group rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:-translate-y-1 hover:border-white/20 hover:bg-white/[0.05]">
              <h3 className="text-xl font-bold">
                Spring Boot
              </h3>

              <p className="mt-2 text-sm text-gray-500">
                REST APIs
              </p>
            </div>


            <div className="group rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:-translate-y-1 hover:border-white/20 hover:bg-white/[0.05]">
              <h3 className="text-xl font-bold">
                PostgreSQL
              </h3>

              <p className="mt-2 text-sm text-gray-500">
                Database
              </p>
            </div>


            <div className="group rounded-2xl border border-white/10 bg-white/[0.03] p-6 transition hover:-translate-y-1 hover:border-white/20 hover:bg-white/[0.05]">
              <h3 className="text-xl font-bold">
                Cloud
              </h3>

              <p className="mt-2 text-sm text-gray-500">
                Deployment
              </p>
            </div>

          </div>

        </div>

      </div>

    </section>
  )
}

export default About